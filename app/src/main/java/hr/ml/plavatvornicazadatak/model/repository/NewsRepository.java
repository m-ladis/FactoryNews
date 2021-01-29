package hr.ml.plavatvornicazadatak.model.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import hr.ml.plavatvornicazadatak.BuildConfig;
import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.listener.ArticlesRetrievedListener;
import hr.ml.plavatvornicazadatak.model.dao.ArticleDao;
import hr.ml.plavatvornicazadatak.model.database.FactoryNewsDatabase;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.entity.NewsResponse;
import hr.ml.plavatvornicazadatak.model.rest.NewsResponseApi;
import hr.ml.plavatvornicazadatak.model.rest.RetrofitNews;
import hr.ml.plavatvornicazadatak.util.NewsRepositoryUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsRepository implements ArticlesRetrievedListener {
    private static final String TAG = "NewsRepository";

    private static final int requestRetrofitUpdateAfterSeconds = 5 * 60;

    private ArticlesRequestListener articlesRequestListener;

    private ArticleDao articleDao;

    public NewsRepository(Application application) {
        FactoryNewsDatabase database = FactoryNewsDatabase.getInstance(application);
        articleDao = database.articleDao();
    }

    public void requestArticles() {
        new GetAllArticles(articleDao, this).execute();
    }

    @Override
    public void articlesRetrievedFromDb(List<Article> articles) {
        boolean updateFromRetrofitNeeded = NewsRepositoryUtils.isUpdateRequired(articles);

        Log.d(TAG, "articlesRetrievedFromDb update required : " + updateFromRetrofitNeeded);

        if (updateFromRetrofitNeeded) getAllArticlesFromRESTAndUpdateDb();
        else articlesRequestListener.articlesReady(articles);
    }

    @Override
    public void articlesRetrievedFromRESTApi(List<Article> articles) {
        NewsRepositoryUtils.setPublishTimeForArticles(articles);
        articlesRequestListener.articlesReady(articles);

        insertArticles(articles);
    }

    public void setArticlesRequestListener(ArticlesRequestListener articlesRequestListener) {
        this.articlesRequestListener = articlesRequestListener;
    }

    private void insertArticles(List<Article> articles) {
        new NewsRepository.InsertAllArticles(articleDao).execute(articles.toArray(new Article[0]));
    }

    private void getAllArticlesFromRESTAndUpdateDb() {
        Retrofit retrofit = RetrofitNews.getInstance();
        NewsResponseApi newsResponseApi = retrofit.create(NewsResponseApi.class);

        Call<NewsResponse> newsResponseCall = newsResponseApi.getResponse(
                "bbc-news", "top", BuildConfig.API_KEY);

        newsResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: successful");

                    if (response.body() != null) {
                        articlesRetrievedFromRESTApi(response.body().getArticles());
                    }
                } else {
                    Log.d(TAG, "http server error");
                    articlesRequestListener.articlesRequestFailed();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d(TAG, "connection to server failed ");
                articlesRequestListener.articlesRequestFailed();
            }
        });
    }

    private static class InsertAllArticles extends AsyncTask<Article, Void, Void> {

        private ArticleDao articleDao;

        public InsertAllArticles(ArticleDao articleDao) {
            this.articleDao = articleDao;
        }

        @Override
        protected Void doInBackground(Article... articles) {

            articleDao.insert(articles);

            return null;
        }
    }

    private static class GetAllArticles extends AsyncTask<Void, Void, List<Article>> {

        private ArticleDao articleDao;

        private ArticlesRetrievedListener listener;

        public GetAllArticles(ArticleDao articleDao, ArticlesRetrievedListener listener) {
            this.articleDao = articleDao;
            this.listener = listener;
        }

        @Override
        protected List<Article> doInBackground(Void... voids) {
            long time = System.currentTimeMillis() - requestRetrofitUpdateAfterSeconds * 1000;
            return articleDao.getAllArticlesNewerThen(time);
        }

        @Override
        protected void onPostExecute(List<Article> articles) {
            super.onPostExecute(articles);

            listener.articlesRetrievedFromDb(articles);
        }
    }
}

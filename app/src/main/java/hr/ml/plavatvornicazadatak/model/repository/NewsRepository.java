package hr.ml.plavatvornicazadatak.model.repository;

import android.util.Log;

import java.util.List;

import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.entity.NewsResponse;
import hr.ml.plavatvornicazadatak.model.rest.NewsResponseApi;
import hr.ml.plavatvornicazadatak.model.rest.RetrofitNews;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsRepository {
    private static final String TAG = "NewsRepository";

    private ArticlesRequestListener articlesRequestListener;

    private List<Article> articles;

    public NewsRepository() {
    }

    public void requestAllArticles() {
        getAllArticlesFromREST();
    }

    private void getAllArticlesFromREST() {
        Retrofit retrofit = RetrofitNews.getInstance();
        NewsResponseApi newsResponseApi = retrofit.create(NewsResponseApi.class);

        Call<NewsResponse> newsResponseCall = newsResponseApi.getResponse(
                "bbc-news", "top", "e4eca91d17b64f16b15af0c4bf18a9f2");

        newsResponseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: successful");
                    articles = response.body().getArticles();
                    articlesRequestListener.articlesReady(articles);
                } else {
                    Log.d(TAG, "onResponse: unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ", t);
            }
        });
    }

    public void setArticlesRequestListener(ArticlesRequestListener articlesRequestListener) {
        this.articlesRequestListener = articlesRequestListener;
    }
}

package hr.ml.plavatvornicazadatak.presenter;


import android.app.Application;

import java.util.List;

import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.repository.NewsRepository;
import hr.ml.plavatvornicazadatak.view.LastNewsIFragment;


public class LastNewsPresenter implements LastNewsIPresenter, ArticlesRequestListener {
    private LastNewsIFragment view;
    private NewsRepository newsRepository;

    public LastNewsPresenter(Application application, LastNewsIFragment view) {
        this.newsRepository = new NewsRepository(application);
        this.view = view;
        newsRepository.setArticlesRequestListener(this);
    }

    @Override
    public void requestLastNews() {
        newsRepository.requestArticles();
    }

    @Override
    public void articlesReadyToShow(List<Article> articles) {
        view.setArticles(articles);
    }
}

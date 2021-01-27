package hr.ml.plavatvornicazadatak.presenter;


import java.util.List;

import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.repository.NewsRepository;
import hr.ml.plavatvornicazadatak.view.LastNewsIFragment;


public class LastNewsPresenter implements LastNewsIPresenter, ArticlesRequestListener {
    private LastNewsIFragment view;
    private NewsRepository newsRepository;

    public LastNewsPresenter(LastNewsIFragment view) {
        this.newsRepository = new NewsRepository();
        this.view = view;
        newsRepository.setArticlesRequestListener(this);
    }

    @Override
    public void showLastNews() {
        newsRepository.requestAllArticles();
    }

    @Override
    public void articlesReady(List<Article> articles) {
        view.setArticles(articles);
    }
}

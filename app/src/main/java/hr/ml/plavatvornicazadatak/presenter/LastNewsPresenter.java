package hr.ml.plavatvornicazadatak.presenter;

import java.util.List;

import javax.inject.Inject;

import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.repository.NewsRepository;
import hr.ml.plavatvornicazadatak.view.LastNewsIFragment;


public class LastNewsPresenter implements LastNewsIPresenter, ArticlesRequestListener {
    private LastNewsIFragment view;
    private NewsRepository newsRepository;

    @Inject
    public LastNewsPresenter(NewsRepository newsRepository, LastNewsIFragment view) {
        this.newsRepository = newsRepository;
        this.view = view;
        newsRepository.setArticlesRequestListener(this);
    }

    @Override
    public void requestLastNews() {
        view.setProgressBarVisibility(true);
        newsRepository.requestArticles();
    }

    @Override
    public void articlesReady(List<Article> articles) {
        view.updateAdapterDataSet(articles);
        view.setProgressBarVisibility(false);
    }

    @Override
    public void articlesRequestFailed() {
        view.showAlertDialog();
        view.setProgressBarVisibility(false);
    }
}

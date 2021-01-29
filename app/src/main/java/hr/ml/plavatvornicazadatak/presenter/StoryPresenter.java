package hr.ml.plavatvornicazadatak.presenter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.listener.ArticlesRequestListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.repository.NewsRepository;
import hr.ml.plavatvornicazadatak.view.StoryIFragment;
import hr.ml.plavatvornicazadatak.view.StoryViewPagerFragment;

public class StoryPresenter implements StoryIPresenter, ArticlesRequestListener {

    private StoryIFragment view;
    private NewsRepository repository;
    private Article currentArticle;

    public StoryPresenter(NewsRepository repository, StoryIFragment view, Article currentArticle) {
        this.repository = repository;
        this.view = view;
        this.currentArticle = currentArticle;
        repository.setArticlesRequestListener(this);
    }

    @Override
    public void requestLastNews() {
        view.setProgressBarVisibility(true);
        repository.requestArticles();
    }

    @Override
    public void articlesReady(List<Article> articles) {
        view.setProgressBarVisibility(false);

        List<StoryViewPagerFragment> fragments = createFragments(articles);
        int currentItem = getCurrentItem(articles);
        view.updateAdapterDataSet(fragments, currentItem);
    }

    private int getCurrentItem(List<Article> articles) {
        int size = articles.size();

        for (int i = 0; i < size; i++) {
            if (articles.get(i).getId() == currentArticle.getId()) return i;
        }
        return -1;
    }

    private List<StoryViewPagerFragment> createFragments(List<Article> articles) {
        List<StoryViewPagerFragment> fragments = new ArrayList<>();

        for (Article article : articles) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("article", article);

            StoryViewPagerFragment fragment = new StoryViewPagerFragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        return fragments;
    }

    @Override
    public void articlesRequestFailed() {
        view.showAlertDialog();
        view.setProgressBarVisibility(false);
    }
}

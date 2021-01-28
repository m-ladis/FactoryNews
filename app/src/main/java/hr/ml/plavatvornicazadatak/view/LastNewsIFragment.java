package hr.ml.plavatvornicazadatak.view;

import java.util.List;

import hr.ml.plavatvornicazadatak.model.entity.Article;

public interface LastNewsIFragment {

    void setArticles(List<Article> articles);

    void setProgressBarVisibility(boolean visibility);

}

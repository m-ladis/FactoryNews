package hr.ml.plavatvornicazadatak.listener;

import java.util.List;

import hr.ml.plavatvornicazadatak.model.entity.Article;

public interface ArticlesRequestListener {

    void articlesReadyToShow(List<Article> articles);

}

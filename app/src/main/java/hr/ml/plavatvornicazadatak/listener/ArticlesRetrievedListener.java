package hr.ml.plavatvornicazadatak.listener;

import java.util.List;

import hr.ml.plavatvornicazadatak.model.entity.Article;

public interface ArticlesRetrievedListener {

    void articlesRetrievedFromDb(List<Article> articles);

    void articlesRetrievedFromRESTApi(List<Article> articles);

}

package hr.ml.plavatvornicazadatak.util;

import java.util.List;

import hr.ml.plavatvornicazadatak.model.entity.Article;

public class NewsRepositoryUtils {

    public static boolean isUpdateRequired(List<Article> articlesFromDb) {
        return articlesFromDb.isEmpty();
    }

    public static void setPublishTimeForArticles(List<Article> articles) {
        long time = System.currentTimeMillis();
        for (Article article : articles) {
            article.setPublishedAt(time);
        }
    }

}

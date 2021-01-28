package hr.ml.plavatvornicazadatak.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import hr.ml.plavatvornicazadatak.model.entity.Article;

@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article... articles);

    @Query(value = "SELECT * FROM article WHERE publishedAt > :timeInMills ORDER BY publishedAt DESC")
    List<Article> getAllArticlesNewerThen(long timeInMills);

}

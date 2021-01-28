package hr.ml.plavatvornicazadatak.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import hr.ml.plavatvornicazadatak.model.dao.ArticleDao;
import hr.ml.plavatvornicazadatak.model.entity.Article;

@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class FactoryNewsDatabase extends RoomDatabase {

    private static FactoryNewsDatabase instance;

    public abstract ArticleDao articleDao();

    public static synchronized FactoryNewsDatabase getInstance(Context context) {
        if(instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FactoryNewsDatabase.class, "factory_news_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}

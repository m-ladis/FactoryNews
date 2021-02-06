package hr.ml.plavatvornicazadatak.di.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import hr.ml.plavatvornicazadatak.di.scope.ApplicationScope;
import hr.ml.plavatvornicazadatak.model.dao.ArticleDao;
import hr.ml.plavatvornicazadatak.model.database.FactoryNewsDatabase;

@Module
public class RoomDatabaseModule {

    @ApplicationScope
    @Provides
    FactoryNewsDatabase provideRoomDatabase(Application application) {
        return FactoryNewsDatabase.getInstance(application);
    }

    @ApplicationScope
    @Provides
    ArticleDao provideArticleDao(FactoryNewsDatabase database) {
        return database.articleDao();
    }

}

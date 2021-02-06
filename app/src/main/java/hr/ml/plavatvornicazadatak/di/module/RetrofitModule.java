package hr.ml.plavatvornicazadatak.di.module;

import dagger.Module;
import dagger.Provides;
import hr.ml.plavatvornicazadatak.di.scope.ApplicationScope;
import hr.ml.plavatvornicazadatak.model.rest.NewsResponseApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @ApplicationScope
    @Provides
    Retrofit provideNewsRetrofit(GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @ApplicationScope
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @ApplicationScope
    @Provides
    NewsResponseApi provideNewsResponseApi(Retrofit retrofit) {
        return retrofit.create(NewsResponseApi.class);
    }
}

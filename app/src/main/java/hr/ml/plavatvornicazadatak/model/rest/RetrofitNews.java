package hr.ml.plavatvornicazadatak.model.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNews {
    private static final String baseUrl = "https://newsapi.org/v1/";

    private static Retrofit instance;

    private RetrofitNews() {}

    public static synchronized Retrofit getInstance(){
        if (instance != null) return instance;

        build();
        return instance;
    }

    private static void build() {
        instance = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

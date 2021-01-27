package hr.ml.plavatvornicazadatak.model.rest;

import hr.ml.plavatvornicazadatak.model.entity.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsResponseApi {

    @GET("articles")
    Call<NewsResponse> getResponse(@Query("source") String source,
                                   @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}

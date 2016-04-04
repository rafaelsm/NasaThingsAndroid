package br.com.rads.nasathings.service;

import br.com.rads.nasathings.apod.ApodResponse;
import br.com.rads.nasathings.patents.response.PatentsResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Rafael on 3/27/16.
 */
public interface NasaService {

    @GET("planetary/apod?")
    Observable<ApodResponse> apod(@Query("date") String date);

    @GET("patents/content?limit=5&")
    Observable<PatentsResponse> patents(@Query("query")String searchTerm);

}

package br.com.rads.nasathings.service;

import br.com.rads.nasathings.apod.ApodResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Rafael on 3/27/16.
 */
public interface NasaService {

    @GET("planetary/apod?")
    Observable<ApodResponse> apod();

}

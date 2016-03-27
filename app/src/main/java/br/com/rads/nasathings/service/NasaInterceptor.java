package br.com.rads.nasathings.service;

import java.io.IOException;

import br.com.rads.nasathings.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Rafael on 3/27/16.
 */
public class NasaInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.NASA_API_KEY).build();
        Request newRequest = chain.request().newBuilder().url(httpUrl).build();
        return chain.proceed(newRequest);
    }

}

package br.com.rads.nasathings.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import br.com.rads.nasathings.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Rafael on 3/27/16.
 */
public class NasaInterceptor implements Interceptor {

    private static final int TIMEOUT = 60;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.NASA_API_KEY).build();
        Request newRequest = chain.request().newBuilder().url(httpUrl).build();
        return chain.proceed(newRequest);
    }

    public static OkHttpClient client() {
        NasaInterceptor interceptor = new NasaInterceptor();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS);

        okHttpClient.interceptors().add(interceptor);
        return okHttpClient.build();
    }
}

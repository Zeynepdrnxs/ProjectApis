package com.medipol.projectapis;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Service {
    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static  HttpLoggingInterceptor loggingInterceptor;
    private static HttpLoggingInterceptor getLogingInterceptor() {
        if (loggingInterceptor == null) {
            loggingInterceptor =  new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        return loggingInterceptor;
    }
    static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient() {

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .addInterceptor(getLogingInterceptor())
                    .build();
        }

        return okHttpClient;
    }

    ServiceApi serviceApi;
    public ServiceApi getServiceApi() {
        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }
        return serviceApi;
    }


}
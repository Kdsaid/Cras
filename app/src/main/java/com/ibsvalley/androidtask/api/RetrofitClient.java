package com.ibsvalley.androidtask.api;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ibsvalley.androidtask.helper.Constants.API_LINK;


public class RetrofitClient {


    private static volatile RetrofitClient mInstance;
    private static Retrofit retrofit;

    public RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        retrofit = new Retrofit.Builder()
                .client(providerOkHttpClient())
                .baseUrl(API_LINK)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OkHttpClient providerOkHttpClient() {
        OkHttpClient.Builder okhttpclient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);



        return okhttpclient.build();
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                mInstance = new RetrofitClient();
            }
        }
        return mInstance;
    }

    public  Api getApi() {
        return retrofit.create(Api.class);
    }

}
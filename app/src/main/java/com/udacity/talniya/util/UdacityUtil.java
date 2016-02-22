package com.udacity.talniya.util;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by talniya on 18/2/16.
 */
public class UdacityUtil {


    public static Retrofit getRetrofit(String baseURL){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;
    }


}

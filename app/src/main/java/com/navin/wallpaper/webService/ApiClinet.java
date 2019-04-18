package com.navin.wallpaper.webService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClinet {

    public static String BASE_URL="http://mrsolution.ir/wallpaper/";
    public static Retrofit retrofit =null;
    public static Retrofit getClinet(){

        if(retrofit==null){
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory
            .create()).build();
        }
        return retrofit;
    }
}

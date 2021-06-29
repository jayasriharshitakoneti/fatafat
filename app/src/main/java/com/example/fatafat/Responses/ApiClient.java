package com.example.fatafat.Responses;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="http://fatema.takatakind.com/app_api/";
    public  static Retrofit retrofit=null;
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}


//http://fatema.takatakind.com/app_api/index.php?p=showAllVideos
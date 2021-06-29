package com.example.fatafat.Responses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //getting all the posts
    @GET("index.php?p=showAllVideos")
    Call<Users> performAllPosts();

}

//http://fatema.takatakind.com/app_api/index.php?p=showAllVideos
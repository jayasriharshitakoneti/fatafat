package com.example.fatafat.Responses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //getting all the posts
    @GET("posts.php")
    Call<Users> performAllPosts();

}

//http://fatema.takatakind.com/app_api/index.php?p=showAllVideos
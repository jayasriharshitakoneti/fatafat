package com.example.fatafat.Responses;

import com.example.fatafat.Models.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {


    @SerializedName("showAllVideos")
    private List<MediaObject> AllPosts;

    public List<MediaObject> getAllPosts() {
        return AllPosts;
    }


}

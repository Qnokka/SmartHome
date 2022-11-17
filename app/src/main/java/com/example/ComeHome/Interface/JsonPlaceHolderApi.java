package com.example.ComeHome.Interface;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("/api/main/getData")
    Call<Map<String,String>> getPosts();
}
package com.example.ComeHome.Interface;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CheckUserApi {
    @POST("/api/users/login")
    Call<Boolean> getUserResult(@Body Map<String, String> users);
}

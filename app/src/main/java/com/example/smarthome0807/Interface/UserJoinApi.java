package com.example.smarthome0807.Interface;

import com.example.smarthome0807.DTO.Users;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserJoinApi {
    @POST("api/users/signUp")
    Call<ResponseBody> getUserResult(@Body Users users);
}
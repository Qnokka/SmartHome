package com.example.smarthome0807.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CheckIDApi {
    @POST("/api/users/idCheck")
    Call<Boolean> getResult(@Body String userId);
}

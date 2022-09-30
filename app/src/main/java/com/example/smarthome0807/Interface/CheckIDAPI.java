package com.example.smarthome0807.Interface;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CheckIDAPI {
    @GET("/api/users/idCheck")
    Call<Boolean> getResult();
}

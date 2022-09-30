package com.example.smarthome0807.DAO;

import android.widget.Toast;

import com.example.smarthome0807.Interface.CheckIDAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AvailableID {
    private String url = "http://10.0.2.2:8081";

    public Boolean checkAvailableId(String userId) {
        boolean result = false;

        //서버에 접속해서 아이디 중복이 있는지 여부 확인
        //if()


        try {
            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CheckIDAPI checkIDApi = retrofit2.create(CheckIDAPI.class);
            Call<Boolean> call1 = checkIDApi.getResult();
            call1.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    boolean response1 = response.body();
                    Toast.makeText("result" + response1, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
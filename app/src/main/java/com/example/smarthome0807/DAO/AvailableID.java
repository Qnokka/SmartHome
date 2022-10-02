package com.example.smarthome0807.DAO;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.smarthome0807.Interface.CheckIDApi;
import com.example.smarthome0807.activity_join;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AvailableID {
    private String url = "http://10.0.2.2:8081";
    boolean result = false;

    public boolean checkAvailableId(String userId) {
        try {
            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CheckIDApi checkIDApi = retrofit2.create(CheckIDApi.class);
            Call<ResponseBody> call1 = checkIDApi.getResult(userId);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    boolean rs = true;
                    Log.i("result", call.toString());
                    Log.i("result", response.body().toString());
                    if ( response.body().equals("true")) {
                        result = true;
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("result", "결과" + result);
        return result;
    }
}
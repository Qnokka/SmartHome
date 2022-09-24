package com.example.smarthome0807;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControlHome {

    private String url = "http://10.0.2.2:8081";

    //Off 버튼 클릭 시 호출되는 함수
    public void windowOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        try {
            controlDataInfo.setAngle(0);
            controlDataInfo.setWindowUp(0);
            //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi postApi = retrofit2.create(PostApi.class);
            Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    System.out.println(response.message());

                    if (!response.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ResponseBody result;
                    result = response.body();
                    if(result != null){
                        Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of windowOff() Method

    public void heaterOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        try {
            controlDataInfo.setHeater(0);
            //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi postApi = retrofit2.create(PostApi.class);
            Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    System.out.println(response.message());

                    if (!response.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ResponseBody result;
                    result = response.body();
                    if(result != null){
                        Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of heaterOff() Method

    public void acOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        try {
            controlDataInfo.setAc(0);
            //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi postApi = retrofit2.create(PostApi.class);
            Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    System.out.println(response.message());

                    if (!response.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ResponseBody result;
                    result = response.body();
                    if(result != null){
                        Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of acOff() Method

    public void AirOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        try {
            controlDataInfo.setAirCleaner(0);
            //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi postApi = retrofit2.create(PostApi.class);
            Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    System.out.println(response.message());

                    if (!response.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ResponseBody result;
                    result = response.body();
                    if(result != null){
                        Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of AirOff() Method 공기

    public void fanOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        try {
            controlDataInfo.setAirOut(0);
            //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

            Retrofit retrofit2 = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostApi postApi = retrofit2.create(PostApi.class);
            Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
            call1.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    System.out.println(response.message());

                    if (!response.isSuccessful()) {
                        //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                        return;
                    }
                    ResponseBody result;
                    result = response.body();
                    if(result != null){
                        Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of fanOff() Method 환기

    public void doorOff(View view) {
        //Onclick Method (JSON 데이터 송신)
        //EditText editText = (EditText) view.findViewById(R.id.editText);
        EditText editText = ((MainActivity)MainActivity.context_main).editText;
        String text = editText.getText().toString().trim();
        String num2 = editText.getText().toString();
        ControlDataInfo controlDataInfo = new ControlDataInfo();

        if(text.getBytes().length <= 0){
            String msg = "값을 입력해주십시오.";
            Toast.makeText(view.getContext(), msg, Toast.LENGTH_LONG).show();
        }else{
            try {
                controlDataInfo.setDoor_passwd(num2);
                controlDataInfo.setDoor(0);
                //Toast.makeText(getApplicationContext(), controlDataInfo.toString(), Toast.LENGTH_LONG).show();

                Retrofit retrofit2 = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PostApi postApi = retrofit2.create(PostApi.class);
                Call<ResponseBody> call1 = postApi.getControlResult(controlDataInfo);
                call1.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        System.out.println(response.message());

                        if (!response.isSuccessful()) {
                            editText.setText(String.valueOf(response.code()));
                            Toast.makeText(view.getContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                            return;
                        }
                        ResponseBody result;
                        result = response.body();
                        if(result != null){
                            Toast.makeText(view.getContext(), "원격 제어 요청 완료되었습니다", Toast.LENGTH_LONG).show();
                            editText.setText(null);

                        }else{
                            Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//end of doorOff() Method
}

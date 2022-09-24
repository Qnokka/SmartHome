package com.example.smarthome0807;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment1 extends Fragment {
    ViewGroup viewGroup;
    //메인 코드 복붙1
    private String url = "http://10.0.2.2:8081";
    private Button m_btnAlert; //팝업 알림창
    private TextView textViewResult;
    private TextView textViewResult2;
    private TextView textViewResult3;
    private TextView textViewResult4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_1,container,false);
        return viewGroup;
    }

    //팝업 알림창 추가코드2 시작
    void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("미세먼지 알림");
        builder.setMessage("미세먼지 등급이 나쁨 이상입니다.");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "창을 닫았습니다.", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
    //팝업 알림창 추가코드2 끝

}
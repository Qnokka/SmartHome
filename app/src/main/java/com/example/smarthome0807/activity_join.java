package com.example.smarthome0807;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.smarthome0807.DTO.Users;
import com.example.smarthome0807.Interface.UserJoinApi;

import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_join extends AppCompatActivity {

    private String url = "http://10.0.2.2:8081";
    private EditText join_id, join_pw, join_name, join_apt, join_adr, join_key;
    private Button join_yes;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //회원 정보 값 받아오기d
        join_id = findViewById(R.id.join_id);
        join_pw = findViewById(R.id.join_pw);
        join_name = findViewById(R.id.join_name);
        join_apt = findViewById(R.id.join_apt);
        join_adr = findViewById(R.id.join_adr);
        join_key = findViewById(R.id.join_key);
        
        //한국어 입력 필터 적용
        join_name.setFilters(new InputFilter[] { filterKor });
        join_apt.setFilters(new InputFilter[] { filterKor });
        join_adr.setFilters(new InputFilter[] { filterKor });

        //회원가입 버튼 클릭 시 수행
        join_yes = findViewById(R.id.join_yes);
        join_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //문자열 형 변환
                String UserId = join_id.getText().toString();
                String UserPw = join_pw.getText().toString();
                String UserName = join_name.getText().toString();
                String UserApt = join_apt.getText().toString();
                String UserAdr = join_adr.getText().toString();
                String UserKey = join_key.getText().toString();

                //한 칸이라도 입력 안했을 경우
                if
                (UserId.equals("") || UserPw.equals("") || UserName.equals("") || UserApt.equals("")|| UserAdr.equals("")|| UserKey.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity_join.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }//end of 한 칸 입력 방지

                //서버로 회원 정보 전송
                userJoin(UserId, UserPw, UserName, UserApt, UserAdr, UserKey);
            }
        });

        //뒤로가기 버튼 - 화면 이동
        ImageButton imageButton = (ImageButton) findViewById(R.id.backBtnSet);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity_login.class);
                startActivity(intent);
            }
        });//end of 뒤로가기 버튼 onClick() 메소드

    }

    //한국어만 입력 받도록 하는 메소드
    public InputFilter filterKor = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps = Pattern.compile("^[-_ㄱ-ㅎ가-힣0-9\\s]*$");
            if(!ps.matcher(source).matches()) {
                String msg = "영문 사용은 불가합니다. 다시 입력해주세요.";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                return "";
            }
            return null;
        }
    };
    //end of inputFilterKor
    
    //해당 내용 서버로 전송하는 메소드
    void userJoin(String UserId, String UserPw, String UserName, String UserApt, String UserAdr, String UserKey){
        Users users = new Users();

        if(UserKey.equals("1")){ //임시 조건문
            try{
                users.setId(UserId);
                users.setPasswd(UserPw);
                users.setName(UserName);
                users.setAddress(UserApt);
                users.setAddressDetail(UserAdr);
                users.setAuthPoint(UserKey);

                Retrofit retrofit2 = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                UserJoinApi userJoinApi = retrofit2.create(UserJoinApi.class);
                Call<ResponseBody> call = userJoinApi.getUserResult(users);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        System.out.println(response.message());

                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "회원 가입에 실패하였습니다", Toast.LENGTH_LONG).show();
                            return;
                        }
                        ResponseBody result;
                        result = response.body();
                        if(result != null){
                            //String msg = UserId+"\n"+UserPw+"\n"+UserName+"\n"+UserApt+"\n"+UserAdr+"\n"+UserKey;
                            Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        }else{
            //인증키 오류
            String msg = "회원 인증키가 일치하지 않습니다.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
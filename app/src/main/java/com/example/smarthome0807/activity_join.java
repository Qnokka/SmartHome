package com.example.smarthome0807;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.smarthome0807.DAO.AvailableID;
import com.example.smarthome0807.DTO.Users;
//요건 변한 겁니다

public class activity_join extends AppCompatActivity {

    private String url = "http://10.0.2.2:8081";
    private EditText join_id, join_pw, join_name, join_apt, join_adr, join_key;
    private Button join_yes, checkId;
    private AlertDialog dialog;
    private String UserId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //회원 정보 값 받아오기
        join_id = findViewById(R.id.join_id);
        join_pw = findViewById(R.id.join_pw);
        join_name = findViewById(R.id.join_name);
        join_apt = findViewById(R.id.join_apt);
        join_adr = findViewById(R.id.join_adr);
        join_key = findViewById(R.id.join_key);

        //중복체크
        checkId = findViewById(R.id.userIdCheck);
        checkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 중복체크
                UserId = join_id.getText().toString();
                if (IdMinimum5(UserId)) {
                    return;
                }

                AvailableID availableId = new AvailableID();
                if (availableId.checkAvailableId(UserId)) { //중복될 경우
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity_join.this);
                    dialog = builder.setMessage("아이디가 중복되었습니다.").setNegativeButton("재입력", null).create();
                    dialog.show();
                    UserId = "";
                    join_id.setText(UserId);
                    return;
                }
            }
        });

        //회원가입 버튼 클릭 시 수행
        join_yes = findViewById(R.id.join_yes);
        join_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 회원가입 버튼
                UserId = join_id.getText().toString();
                String UserPw = join_pw.getText().toString();
                String UserName = join_name.getText().toString();
                String UserApt = join_apt.getText().toString();
                String UserAdr = join_adr.getText().toString();
                String UserKey = join_key.getText().toString();

                // id 제약조건 : 5글자 이상.
                if (IdMinimum5(UserId)) {
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (UserId.equals("") || UserPw.equals("") || UserName.equals("") || UserApt.equals("") || UserAdr.equals("") || UserKey.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity_join.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }//end of 한 칸 입력 방지

                //ID,s Passwd -> 특수문자는 어떻게 할지 나중에 보완


                // 이름 -> 한글, 영문
                // 자치구 -> 한글
                // 상세주소  -> 한글

                Users users = new Users();
            } // end of onClick();
        }); // end of join_yse.setOnClickListener();

        //뒤로가기 버튼 - 화면 이동
        ImageButton imageButton = (ImageButton) findViewById(R.id.backBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_login.class);
                startActivity(intent);
            }
        });//end of 뒤로가기 버튼 onClick() 메소드
    }

    protected boolean IdMinimum5(String UserId) {
        //ID 5글자 미만일 경우
        if (UserId.length() < 5) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity_join.this);
            dialog = builder.setMessage("아이디를 영문  5글자 이상 입력해주세요").setNegativeButton("확인", null).create();
            dialog.show();
            return true;
        }
        return false;
    }
}

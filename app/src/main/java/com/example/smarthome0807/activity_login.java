package com.example.smarthome0807;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //계정 생성 버튼 - 화면 이동
        Button joinMember = (Button) findViewById(R.id.join_qid);
        joinMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity_join.class);
                startActivity(intent);
            }
        });

        //일단 임시로 만든 홈 넘어가는 onclick (로그인 : 회원 인증 버튼 누를 시 수행)
        Button loginMember = (Button) findViewById(R.id.login);

        //Users table에 저장된 id, password 값
        String user_id;
        String user_pw;

        loginMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자 입력 텍스트 값
                EditText login_id = findViewById(R.id.login_id);
                String input_id = login_id.getText().toString();
                EditText login_pw = findViewById(R.id.login_pw);
                String input_pw = login_pw.getText().toString();
                String len_id = input_id.trim();
                String len_pw = input_pw.trim();

                if(len_id.getBytes().length <= 0 || len_pw.getBytes().length <= 0){
                    String msg = "모두 입력해주세요.";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    if(input_id.equals("baekkoji") && (input_pw.equals("1234"))){
                        //화면 이동 구문
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        String msg = "비밀번호 또는 아이디가 일치하지 않습니다.";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
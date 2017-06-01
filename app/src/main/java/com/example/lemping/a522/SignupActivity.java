package com.example.lemping.a522;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Lemping on 2017-05-23.
 */

public class SignupActivity extends Activity {

    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        helper = new DBHelper(SignupActivity.this, "SIGN.db" , null , 1);

        final EditText signupid = (EditText) findViewById(R.id.signupid);
        final EditText signuppw = (EditText) findViewById(R.id.signuppw);
        final EditText signuppwh = (EditText) findViewById(R.id.signuppwh);
        final Button signupok = (Button) findViewById(R.id.signupok);
        final Button signupno = (Button) findViewById(R.id.signupno);

        signupok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (signupid.getText().toString().equals("") || signuppw.getText().toString().equals("") || signuppwh.getText().toString().equals(""))
                    Toast.makeText(SignupActivity.this, "모든 칸을 채워주세요", Toast.LENGTH_SHORT).show();

                else if ( !signuppw.getText().toString().equals(signuppwh.getText().toString()) )
                    Toast.makeText(SignupActivity.this, "비밀번호 확인을 확인 해 주세요", Toast.LENGTH_SHORT).show();

                else {
                        String id = signupid.getText().toString();
                        String pw = signuppw.getText().toString();

                        helper.insert(id, pw);

                        Log.d("id", id);
                        Log.d("pw", pw);

                        Toast.makeText(SignupActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
        });

        signupno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

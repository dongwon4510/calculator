package com.example.lemping.a522;

        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

/**
 * Created by Lemping on 2017-05-23.
 */

public class LoginActivity extends Activity {

    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText loginid = (EditText) findViewById(R.id.loginid);
        final EditText loginpw = (EditText) findViewById(R.id.loginpw);
        Button login = (Button) findViewById(R.id.login);
        final Button signup = (Button) findViewById(R.id.signup);

        helper = new DBHelper(LoginActivity.this, "SIGN.db", null, 1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aaaaaa","aaaaaa");
                db = helper.getReadableDatabase();
                String id = loginid.getText().toString();
                String pw = loginpw.getText().toString();
                String dbid = null;
                String dbpw = null;
                Log.d("bbbbbb","bbbbbb");
                Cursor cursor = db.rawQuery("SELECT * FROM SIGN" , null);
                while (cursor.moveToNext()) {
                    dbid = cursor.getString(cursor.getColumnIndex("id"));
                    dbpw = cursor.getString(cursor.getColumnIndex("pw"));
                }
                Log.d("dbid",dbid);
                Log.d("dbpw",dbpw);


                if (id.equals(dbid) && pw.equals(dbpw)) {
                    Toast.makeText(LoginActivity.this, "로그인", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pw)) {
                    Toast.makeText(LoginActivity.this, "ID와 Password를 모두 입력 해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "ID와 Password가 맞는지 확인하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }

        });

    }
}

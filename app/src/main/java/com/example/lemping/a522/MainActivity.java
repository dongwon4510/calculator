package com.example.lemping.a522;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int num = 0;
    private int a;
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper (MainActivity.this, "OP.db" , null , 1);

        Button outputac = (Button) findViewById(R.id.outputac);
        final EditText edt = (EditText) findViewById(R.id.edt);
        final TextView tv = (TextView) findViewById(R.id.print);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button mul = (Button) findViewById(R.id.mul);
        Button div = (Button) findViewById(R.id.div);
        Button es = (Button) findViewById(R.id.es);
        Button ac = (Button) findViewById(R.id.ac);
        Button btn0 = (Button) findViewById(R.id.zero);
        Button btn1 = (Button) findViewById(R.id.one);
        Button btn2 = (Button) findViewById(R.id.two);
        Button btn3 = (Button) findViewById(R.id.three);
        Button btn4 = (Button) findViewById(R.id.four);
        Button btn5 = (Button) findViewById(R.id.five);
        Button btn6 = (Button) findViewById(R.id.six);
        Button btn7 = (Button) findViewById(R.id.seven);
        Button btn8 = (Button) findViewById(R.id.eight);
        Button btn9 = (Button) findViewById(R.id.nine);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("1");
                else
                    edt.setText("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("2");
                else
                    edt.setText("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("3");
                else
                    edt.setText("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("4");
                else
                    edt.setText("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("5");
                else
                    edt.setText("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("6");
                else
                    edt.setText("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("7");
                else
                    edt.setText("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("8");
                else
                    edt.setText("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("9");
                else
                    edt.setText("9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt != null)
                    edt.append("0");
                else
                    edt.setText("0");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.valueOf(edt.getText().toString().trim());
                edt.setText("");
                num = 1;
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.valueOf(edt.getText().toString().trim());
                edt.setText("");
                num = 2;
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.valueOf(edt.getText().toString().trim());
                edt.setText("");
                num = 3;
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.valueOf(edt.getText().toString().trim());
                edt.setText("");
                num = 4;
            }
        });

        es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num == 1) {
                    a = a + Integer.valueOf(edt.getText().toString().trim());
                    edt.setText(Integer.toString(a));
                }
                else if (num == 2) {
                    a = a - Integer.valueOf(edt.getText().toString().trim());
                    edt.setText(Integer.toString(a));
                }
                else if (num == 3) {
                    a = a * Integer.valueOf(edt.getText().toString().trim());
                    edt.setText(Integer.toString(a));
                }
                else if (num == 4) {
                    a = a / Integer.valueOf(edt.getText().toString().trim());
                    edt.setText(Integer.toString(a));
                }
//                a = Integer.valueOf(edt.getText().toString().trim());
                edt.setText(Integer.toString(a));

                String output = edt.getText().toString();
                helper.insert2(output);

                tv.setText(helper.select());
            }
        });

        outputac.setOnClickListener(new View.OnClickListener() { //db 내용 삭제
            @Override
            public void onClick(View v) {
                String output = edt.getText().toString();
                helper.delete(output);
                tv.setText(helper.select());
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               edt.setText("");
                }
        });
    }
    }
package com.example.practicequizapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class activity_second extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn_back;
    Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn_back = findViewById(R.id.btn_back);

        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Activity4(v);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_second.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
    public void call_Activity4(View view){
        String value;
        switch (view.getId()){
            case R.id.btn1:
                value = "image1";
                break;
            case R.id.btn2:
                value = "image2";
                break;
            case R.id.btn3:
                value = "image3";
                break;
            case R.id.btn4:
                value = "image4";
                break;
            case R.id.btn5:
                value = "image5";
                break;
            case R.id.btn6:
                value = "image6";
                break;
            case R.id.btn7:
                value = "image7";
                break;
            case R.id.btn8:
                value = "image8";
                break;
            case R.id.btn9:
                value = "image9";
                break;
            case R.id.btn10:
                value = "image10";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());

        }
        Intent intent = new Intent(activity_second.this, activity_four.class);
        intent.putExtra("id", value);
        startActivity(intent);
    }
}
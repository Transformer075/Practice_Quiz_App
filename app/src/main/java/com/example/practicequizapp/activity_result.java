package com.example.practicequizapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_result extends AppCompatActivity {
    TextView textView;
    Button btn_result;
    Toolbar toolbar7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.result);
        btn_result = findViewById(R.id.button);
        toolbar7 = findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar7);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message ="Correct Answers: " + intent.getIntExtra("correctAnswerCount4", 0);
        textView.setText(message);


        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent2);
            }
        });



    }
}
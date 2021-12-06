package com.example.practicequizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    Button btn_Practice;
    Button btn_Quiz;
    Button btn_repo;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btn_Practice = findViewById(R.id.btn_secondActivity);
        btn_Quiz = findViewById(R.id.btn_thirdActivity);
        btn_repo = findViewById(R.id.btn_repo);
        toolbar = findViewById(R.id.toolbar);
        Intent intent;
        btn_Practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, activity_second.class);
                startActivity(intent);
            }
        });
        btn_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, activity_three.class);
                startActivity(intent);
            }
        });
        btn_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://github.com/Transformer075/Practice_Quiz_App");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });


    }
}
package com.example.practicequizapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_four extends AppCompatActivity {
    ImageView imageView;
    String imageName;
    Button btn_back;
    Toolbar toolbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        imageView = findViewById(R.id.imageView);
        btn_back = findViewById(R.id.btn_back2);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        imageName = intent.getStringExtra("id");
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(resId);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_four.this, activity_second.class);
                startActivity(intent);
            }
        });

    }
}
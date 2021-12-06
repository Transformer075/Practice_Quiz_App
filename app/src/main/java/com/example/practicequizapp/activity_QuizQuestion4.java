package com.example.practicequizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class activity_QuizQuestion4 extends AppCompatActivity {

    String[] categoryArray = {"Halqiyah", "Lahatiyah", "Shajariyah-Haafiyah"};
    ImageView image;
    TextView viewStatement4;
    RadioButton btn_radio4_1, btn_radio4_2, btn_radio4_3;
    RadioGroup radioGroup4;
    Button btn_result;
    int correctAnswerCount4 = 0;
    Toolbar toolbar6;
    boolean go4 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question4);

        Intent intent1 = getIntent();
        correctAnswerCount4 = intent1.getIntExtra("correctAnswerCount4", 0);

        image = (ImageView) findViewById(R.id.textViewImage);
        viewStatement4 = findViewById(R.id.imageStatement);
        btn_radio4_1 = findViewById(R.id.btn_radio4_1);
        btn_radio4_2 = findViewById(R.id.btn_radio4_2);
        btn_radio4_3 = findViewById(R.id.btn_radio4_3);
        btn_result = findViewById(R.id.btn_result);
        radioGroup4 = findViewById(R.id.radioGroup4);

        toolbar6 = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar6);

        Intent intent = getIntent();
        correctAnswerCount4 = intent.getIntExtra("correctAnswerCount4", 0);
        Log.d("T1", "onClick: value received from 3" + correctAnswerCount4);

        String randomImage = "qimage" + 0;
        int resId1 = getResources().getIdentifier(randomImage, "drawable", getPackageName());
        image.setImageResource(resId1);

        viewStatement4.setText("This image belongs to which Makharij?");

        btn_radio4_1.setText(categoryArray[0]);
        btn_radio4_2.setText(categoryArray[1]);
        btn_radio4_3.setText(categoryArray[2]);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(go4){
                    Intent intent2 = new Intent(activity_QuizQuestion4.this, activity_result.class);
                    intent2.putExtra("correctAnswerCount4", correctAnswerCount4);
                    Log.d("T1", "onClick: value send to result" + correctAnswerCount4);
                    startActivity(intent2);
                }

            }
        });
    }
    public void onRadioButtonClicked4(View view) {
        Integer answer4 = view.getId();
        btn_radio4_1.setEnabled(false);
        btn_radio4_2.setEnabled(false);
        btn_radio4_3.setEnabled(false);
        go4 = true;
        RadioButton radio4 = findViewById(answer4);
        if(categoryArray[0].equals(radio4.getText().toString()))
            correctAnswerCount4++;
    }
}
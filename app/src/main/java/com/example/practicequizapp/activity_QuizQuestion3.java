package com.example.practicequizapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class activity_QuizQuestion3 extends AppCompatActivity {
    String[] arabicLetters = {"أ ہ","ع ح","غ خ","ق","ک","ج ش ی","ض","ل","ن","ر","ت د ط","ظ  ذ  ث","ص ز س","م ن","ف","ب","م","و","باَ بوُ بىِ"};
    String[] soundProducedFrom = {"End of Throat", "Middle of Throat", "Start of the Throat", "Base of Tongue which" +
            "is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth",
            "Tongue touching the center of the mouth roof", "One side of the tongue touching the molar teeth",
            "Rounded tip of the tongue touching the base of the", "Rounded tip of the tongue touching the base of the frontal 6 teeth",
            "Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",
            "Tip of the tongue touching the base of the front 2 teeth", "Tip of the tongue touching the tip of the frontal 2 teeth"
            , "Tip of the tongue comes between the front top and bottom teeth",
            "While pronouncing the ending sound of  م  or ن , bring the vibration to the nose",
            "Tip of the two upper jaw teeth touches the inner part of the lower lip",
            "Inner part of the both lips touch each other", "Outer part of both lips touch each other",
            "Rounding both lips and not closing the mouth", "Mouth empty space while speaking words like  باَ بوُ بىِ"};

    TextView statementView3;
    RadioButton btn_radio3_1, btn_radio3_2, btn_radio3_3;
    RadioGroup radioGroup3;
    Button btn_next4;
    int correctAnswerCount3 = 0;
    int randomNumber3;
    boolean go3 = false;
    Toolbar toolbar5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question3);

        Intent intent1 = getIntent();
        correctAnswerCount3 = intent1.getIntExtra("correctAnswerCount3", 0);
        Log.d("T1", "onClick: value received from 2" + correctAnswerCount3);

        statementView3 = findViewById(R.id.statementView3);
        btn_radio3_1 = findViewById(R.id.btn_radio3_1);
        btn_radio3_2 = findViewById(R.id.btn_radio3_2);
        btn_radio3_3 = findViewById(R.id.btn_radio3_3);
        btn_next4 = findViewById(R.id.btn_next4);
        radioGroup3 = findViewById(R.id.radioGroup3);

        toolbar5 = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar5);

        Random rand = new Random();
        randomNumber3 = rand.nextInt(19);

        statementView3.setText("Which Arabic letters produce sound from " + soundProducedFrom[randomNumber3] + "?");
        btn_radio3_1.setText(arabicLetters[randomNumber3]);
        if(randomNumber3 > 1){
            btn_radio3_2.setText(arabicLetters[randomNumber3 - 1]);
        }
        else {
            btn_radio3_2.setText(arabicLetters[randomNumber3 + 2]);
        }

        if (randomNumber3 < 18){
            btn_radio3_3.setText(arabicLetters[randomNumber3 + 1]);
        }
        else {
            btn_radio3_3.setText(arabicLetters[randomNumber3 - 2]);
        }
        btn_next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(go3){
                    Intent intent2 = new Intent(activity_QuizQuestion3.this, activity_QuizQuestion4.class);
                    intent2.putExtra("correctAnswerCount4", correctAnswerCount3);
                    Log.d("T1", "onClick: value send to 4" + correctAnswerCount3);
                    startActivity(intent2);
                }
            }
        });
    }

    public void onRadioButtonClicked3(View view) {
        Integer answer3 = view.getId();
        btn_radio3_1.setEnabled(false);
        btn_radio3_2.setEnabled(false);
        btn_radio3_3.setEnabled(false);
        go3 = true;
        RadioButton radio3 = findViewById(answer3);
        if(arabicLetters[randomNumber3].equals(radio3.getText().toString()))
            correctAnswerCount3++;
    }
}
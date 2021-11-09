package com.example.practicequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class activity_QuizQuestion2 extends AppCompatActivity {

    String[] categoryArray = {"Halqiyah", "Lahatiyah", "Shajariyah-Haafiyah", "Tarfiyah", "Nit-eeyah", "Lisaveyah"
            , "Ghunna"};
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

    TextView statementView2;
    RadioButton btn_radio2_1, btn_radio2_2, btn_radio2_3;
    RadioGroup radioGroup2;
    Button btn_next3;
    int correctAnswerCount2 = 0;
    int randomNumber2;
    boolean go2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question2);

        Intent intent1 = getIntent();
        correctAnswerCount2 = intent1.getIntExtra("correctAnswerCount", 0);
        Log.d("T1", "onClick: value received from 1" + correctAnswerCount2);

        statementView2 = findViewById(R.id.statementview2);
        btn_radio2_1 = findViewById(R.id.btn_radio2_1);
        btn_radio2_2 = findViewById(R.id.btn_radio2_2);
        btn_radio2_3 = findViewById(R.id.btn_radio2_3);
        btn_next3 = findViewById(R.id.btn_next3);
        radioGroup2 = findViewById(R.id.radioGroup2);

        Random rand = new Random();
        randomNumber2 = rand.nextInt(19);

        statementView2.setText("Which Arabic letters produce sound from " + soundProducedFrom[randomNumber2] + "?");
        btn_radio2_2.setText(arabicLetters[randomNumber2]);
        if(randomNumber2 > 1){
            btn_radio2_1.setText(arabicLetters[randomNumber2 - 1]);
        }
        else {
            btn_radio2_1.setText(arabicLetters[randomNumber2 + 2]);
        }

        if (randomNumber2 < 18){
            btn_radio2_3.setText(arabicLetters[randomNumber2 + 1]);
        }
        else {
            btn_radio2_3.setText(arabicLetters[randomNumber2 - 2]);
        }

        btn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(go2){
                    Intent intent2 = new Intent(activity_QuizQuestion2.this, activity_QuizQuestion3.class);
                    intent2.putExtra("correctAnswerCount3", correctAnswerCount2);
                    Log.d("T1", "onClick: value send to 3" + correctAnswerCount2);
                    startActivity(intent2);

                }
            }
        });
    }

    public void onRadioButtonClicked2(View view) {
        Integer answer2 = view.getId();
        btn_radio2_1.setEnabled(false);
        btn_radio2_2.setEnabled(false);
        btn_radio2_3.setEnabled(false);
        go2 = true;
        RadioButton radio2 = findViewById(answer2);
        if(arabicLetters[randomNumber2].equals(radio2.getText().toString()))
            correctAnswerCount2++;
    }
}
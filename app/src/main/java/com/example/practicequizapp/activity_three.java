package com.example.practicequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class activity_three extends AppCompatActivity {

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

    TextView statementView;
    RadioButton btn_radio1, btn_radio2, btn_radio3;
    RadioGroup radioGroup;
    Button btn_next1;
    int correctAnswersCount = 0;
    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        statementView = findViewById(R.id.statementView);
        btn_radio1 = findViewById(R.id.btn_radio1);
        btn_radio2 = findViewById(R.id.btn_radio2);
        btn_radio3 = findViewById(R.id.btn_radio3);
        btn_next1 = findViewById(R.id.btn_next1);
        radioGroup = findViewById(R.id.radioGroup);

        Random rand = new Random();
        randomNumber = rand.nextInt(19);

        statementView.setText("Which Arabic letters produce sound from " + soundProducedFrom[randomNumber] + "?");
        btn_radio1.setText(arabicLetters[randomNumber]);
        if(randomNumber > 1){
            btn_radio2.setText(arabicLetters[randomNumber - 1]);
        }
        else {
            btn_radio2.setText(arabicLetters[randomNumber + 2]);
        }

        if (randomNumber < 18){
            btn_radio3.setText(arabicLetters[randomNumber + 1]);
        }
        else {
            btn_radio3.setText(arabicLetters[randomNumber - 2]);
        }

        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_three.this, activity_QuizQuestion2.class);
                intent.putExtra("correctAnswerCount", correctAnswersCount);
                startActivity(intent);
            }
        });


    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btn_radio1:
                if (checked && arabicLetters[randomNumber] == btn_radio1.getText())
                    correctAnswersCount++;
                    break;
            case R.id.btn2:
                if (checked && arabicLetters[randomNumber] == btn_radio2.getText())
                    correctAnswersCount++;
                    break;
            case R.id.btn3:
                if (checked && arabicLetters[randomNumber] == btn_radio3.getText())
                    correctAnswersCount++;
                    break;
        }
    }
}
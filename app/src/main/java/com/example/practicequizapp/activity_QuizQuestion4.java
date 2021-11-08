package com.example.practicequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
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
    int randomNumber4;
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

        Intent intent = getIntent();
        correctAnswerCount4 = intent.getIntExtra("correctAnswer4", 0);

        Random rand1 = new Random();
        randomNumber4 = rand1.nextInt(3);
        String randomImage = "qimage" + randomNumber4;
        int resId1 = getResources().getIdentifier(randomImage, "drawable", getPackageName());
        image.setImageResource(resId1);

        viewStatement4.setText("This image belongs to which Makharij?");
        Random rand2 = new Random();
        int randomNumber4 = rand2.nextInt(3);
        btn_radio4_1.setText(categoryArray[randomNumber4]);
        if(randomNumber4 > 1){
            btn_radio4_2.setText(categoryArray[randomNumber4 - 1]);
        }
        else {
            btn_radio4_2.setText(categoryArray[randomNumber4 + 2]);
        }

        if (randomNumber4 < 2){
            btn_radio4_3.setText(categoryArray[randomNumber4 + 1]);
        }
        else {
            btn_radio4_3.setText(categoryArray[randomNumber4 - 2]);
        }
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent2 = new Intent(activity_QuizQuestion3.this, activity_QuizQuestion3.class);
                //intent2.putExtra("correctAnswerCount4", correctAnswerCount3);
                //startActivity(intent2);
            }
        });
    }
    public void onRadioButtonClicked4(View view) {
        boolean checked4 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btn_radio4_1:
                if (checked4 && categoryArray[randomNumber4] == btn_radio4_1.getText())
                    correctAnswerCount4++;
                break;
            case R.id.btn_radio4_2:
                if (checked4 && categoryArray[randomNumber4] == btn_radio4_2.getText())
                    correctAnswerCount4++;
                break;
            case R.id.btn_radio4_3:
                if (checked4 && categoryArray[randomNumber4] == btn_radio4_3.getText())
                    correctAnswerCount4++;
                break;
        }
    }
}
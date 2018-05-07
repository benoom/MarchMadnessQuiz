package com.example.android.marchmadnessquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //setting the initial value of the correct answer tally to 0
    int answerTally = 0;

    //Creating global instance variables for each question's answer
    private RadioButton radioButtonQ1;
    private RadioButton radioButtonQ2;
    private EditText editTextQ3;
    private RadioButton radioButtonQ4;
    private RadioButton radioButtonQ5;
    private EditText editTextQ6;
    private RadioButton radioButtonQ7;
    private CheckBox checkBoxQ8A;
    private CheckBox checkBoxQ8B;
    private CheckBox checkBoxQ8C;
    private CheckBox checkBoxQ8D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing global instance variables for each question's answer
        radioButtonQ1 = findViewById(R.id.q1_answer_B);
        radioButtonQ2 = findViewById(R.id.q2_answer_C);
        editTextQ3 = findViewById(R.id.q3_answer);
        radioButtonQ4 = findViewById(R.id.q4_answer_B);
        radioButtonQ5 = findViewById(R.id.q5_answer_A);
        editTextQ6 = findViewById(R.id.q6_answer);
        radioButtonQ7 = findViewById(R.id.q7_answer_C);
        checkBoxQ8A = findViewById(R.id.q8_answer_A);
        checkBoxQ8B = findViewById(R.id.q8_answer_B);
        checkBoxQ8C = findViewById(R.id.q8_answer_C);
        checkBoxQ8D = findViewById(R.id.q8_answer_D);

    }

    //method for handling when the user clicks the Submit button
    public void submitButton(View view) {

        //checking the correct answer is marked for question No. 1, add 1 to tally if correct
        boolean q1Answer = radioButtonQ1.isChecked();

        if (q1Answer) {
            answerTally++;
        }

        //checking the correct answer is marked for question No.2, add 1 to tally if correct
        boolean q2Answer = radioButtonQ2.isChecked();

        if (q2Answer) {
            answerTally++;
        }

        //Checking the correct answer is entered for question No. 3, add 1 to tally if correct
        if (editTextQ3.getText().toString().equals("Kansas City")) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 4, add 1 to tally if correct
        boolean q4Answer = radioButtonQ4.isChecked();

        if (q4Answer) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 5, add 1 to tally if correct
        boolean q5Answer = radioButtonQ5.isChecked();

        if (q5Answer) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 6, add 1 to tally if correct
        if (editTextQ6.getText().toString().equals("Glen Rice")) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 7, add 1 to tally if correct
        boolean q7Answer = radioButtonQ7.isChecked();

        if (q7Answer) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 8, add 1 to tally if A&C selected
        boolean q8AnswerA = checkBoxQ8A.isChecked();

        boolean q8WrongAnswerB = checkBoxQ8B.isChecked();

        boolean q8AnswerC = checkBoxQ8C.isChecked();

        boolean q8WrongAnswerD = checkBoxQ8D.isChecked();

        if (q8AnswerA && q8AnswerC) {
            answerTally++;

            //Subtracting a point from the tally if B or D are selected
            if (q8WrongAnswerB || q8WrongAnswerD) {
                answerTally--;
            }
        }

        //A toast is displayed at the bottom of the screen to let the user know how many answers were correct
        if (answerTally == 8) {
            Toast toast = Toast.makeText(this, getResources().getString(R.string.perfect_score_toast), Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, getResources().getString(R.string.toast) + " " + answerTally + " " + getResources().getString(R.string.toast2), Toast.LENGTH_LONG);
            toast.show();
        }
        answerTally = 0;
    }

    //Resetting the selections in the quiz when the Reset button is clicked
    public void resetButton(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}

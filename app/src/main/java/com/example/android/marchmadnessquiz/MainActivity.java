package com.example.android.marchmadnessquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //setting the initial value of the correct answer tally to 0
    int answerTally = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method for handling when the user clicks the Submit button
    public void submitButton(View view) {

        //checking the correct answer is marked for question No. 1, add 1 to tally if correct
        RadioButton radioButtonQ1 = findViewById(R.id.q1_answer_B);
        boolean q1Answer = radioButtonQ1.isChecked();

        if (q1Answer) {
            answerTally++;
        }

        //checking the correct answer is marked for question No.2, add 1 to tally if correct
        RadioButton radioButtonQ2 = findViewById(R.id.q2_answer_C);
        boolean q2Answer = radioButtonQ2.isChecked();

        if (q2Answer) {
            answerTally++;
        }

        //Checking the correct answer is entered for question No. 3, add 1 to tally if correct
        EditText editTextQ3 = findViewById(R.id.q3_answer);
        if (editTextQ3.getText().toString().equals("Kansas City")) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 4, add 1 to tally if correct
        RadioButton radioButtonQ4 = findViewById(R.id.q4_answer_B);
        boolean q4Answer = radioButtonQ4.isChecked();

        if (q4Answer) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 5, add 1 to tally if correct
        RadioButton radioButtonQ5 = findViewById(R.id.q5_answer_A);
        boolean q5Answer = radioButtonQ5.isChecked();

        if (q5Answer) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 6, add 1 to tally if correct
        EditText editTextQ6 = findViewById(R.id.q6_answer);
        if (editTextQ6.getText().toString().equals("Glen Rice")) {
            answerTally++;
        }

        //Checking the correct answer is marked for question No. 7, add 1 to tally if correct
        RadioButton radioButtonQ7 = findViewById(R.id.q7_answer_C);
        boolean q7Answer = radioButtonQ7.isChecked();

        if (q7Answer) {
            answerTally++;
        }
        //Log.i("MyActivity", "should be true " + q7Answer);


        //Checking the correct answer is marked for question No. 8, add 1 to tally if A&C selected
        CheckBox checkBoxQ8A = findViewById(R.id.q8_answer_A);
        boolean q8AnswerA = checkBoxQ8A.isChecked();

        CheckBox checkBoxQ8C = findViewById(R.id.q8_answer_C);
        boolean q8AnswerC = checkBoxQ8C.isChecked();

        CheckBox checkBoxQ8B = findViewById(R.id.q8_answer_B);
        boolean q8WrongAnswerB = checkBoxQ8B.isChecked();

        CheckBox checkBoxQ8D = findViewById(R.id.q8_answer_D);
        boolean q8WrongAnswerD = checkBoxQ8D.isChecked();

        if (q8AnswerA && q8AnswerC) {
            answerTally++;

            //Subtracting a point from the tally if B or D are selected
            if (q8WrongAnswerB || q8WrongAnswerD) {
                answerTally--;
            }
        }

        //A toast is displayed at the bottom of the screen to let the user know how many answers were correct
        Toast toast = Toast.makeText(this, "You got " + answerTally + " out of 8, Congratulations!", Toast.LENGTH_LONG);
        toast.show();
        answerTally = 0;
    }

    //Resetting the selections in the quiz when the Reset button is clicked
    public void resetButton(View view) {
        RadioGroup q1RadioGroup = findViewById(R.id.q1_RadioGroup);
        q1RadioGroup.clearCheck();

        RadioGroup q2RadioGroup = findViewById(R.id.q2_RadioGroup);
        q2RadioGroup.clearCheck();

        EditText q3EditText = findViewById(R.id.q3_answer);
        q3EditText.getText().clear();

        RadioGroup q4RadioGroup = findViewById(R.id.q4_RadioGroup);
        q4RadioGroup.clearCheck();

        RadioGroup q5RadioGroup = findViewById(R.id.q5_RadioGroup);
        q5RadioGroup.clearCheck();

        EditText q6EditText = findViewById(R.id.q6_answer);
        q6EditText.getText().clear();

        RadioGroup q7RadioGroup = findViewById(R.id.q7_RadioGroup);
        q7RadioGroup.clearCheck();

        CheckBox q8AnswerA = findViewById(R.id.q8_answer_A);
        if (q8AnswerA.isChecked()) {
            q8AnswerA.setChecked(false);
        }
        CheckBox q8AnswerB = findViewById(R.id.q8_answer_B);
        if (q8AnswerB.isChecked()) {
            q8AnswerB.setChecked(false);
        }

        CheckBox q8AnswerC = findViewById(R.id.q8_answer_C);
        if (q8AnswerC.isChecked()) {
            q8AnswerC.setChecked(false);
        }

        CheckBox q8AnswerD = findViewById(R.id.q8_answer_D);
        if (q8AnswerD.isChecked()) {
            q8AnswerD.setChecked(false);
        }
    }
}

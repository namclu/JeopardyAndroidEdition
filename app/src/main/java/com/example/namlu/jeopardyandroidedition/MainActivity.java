package com.example.namlu.jeopardyandroidedition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    static final int NUM_OF_QUESTIONS = 4;
    /*
     * @param questionsCorrect tracks the number of questions answered correctly
     * @param questionOneToggle tracks if question one
     */
    int correctResponses = 0;
    boolean questionOnePointsAwarded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Reference to RadioButton
        RadioGroup questionOneGroup;

        // Reference to CheckBoxs
        CheckBox questionTwoA;
        CheckBox questionTwoB;
        CheckBox questionTwoC;
        CheckBox questionTwoD;

        // Reference to Button
        Button submitButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listener for question 1
        questionOneGroup = (RadioGroup) findViewById(R.id.rg_question_one);
        questionOneGroup.setOnCheckedChangeListener(this);

        // Listener for question 2
        questionTwoA = (CheckBox) findViewById(R.id.cb_question_two_a);
        questionTwoA.setOnCheckedChangeListener(this);

        questionTwoB = (CheckBox) findViewById(R.id.cb_question_two_b);
        questionTwoB.setOnCheckedChangeListener(this);

        questionTwoC = (CheckBox) findViewById(R.id.cb_question_two_c);
        questionTwoC.setOnCheckedChangeListener(this);

        questionTwoD = (CheckBox) findViewById(R.id.cb_question_two_d);
        questionTwoD.setOnCheckedChangeListener(this);

        // Listener for Submit button
        submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.cb_question_two_a:
                if (isChecked) {
                    Toast.makeText(this, "Checkbox a selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cb_question_two_b:
                if (isChecked) {
                    Toast.makeText(this, "Checkbox b selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cb_question_two_c:
                if (isChecked) {
                    Toast.makeText(this, "Checkbox c selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cb_question_two_d:
                if (isChecked) {
                    Toast.makeText(this, "Checkbox d selected", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
        // If response is correct, set points awarded to true, else set to false
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_question_one_a:
                correctResponses++;
                questionOnePointsAwarded = true;
                break;
            case R.id.rb_question_one_b:
            case R.id.rb_question_one_c:
            case R.id.rb_question_one_d:
                if (questionOnePointsAwarded) {
                    correctResponses--;
                    questionOnePointsAwarded = false;
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        // When user clicks on 'Submit', present Toast message with user's score
        if (view.getId() == R.id.button_submit) {
            Toast.makeText(this, "Answers correct: " + correctResponses + "/" + NUM_OF_QUESTIONS, Toast.LENGTH_SHORT).show();
        }
    }

    // Checks if response given to CheckBox questions is correct
    void validateCheckBoxResponse() {

    }
}

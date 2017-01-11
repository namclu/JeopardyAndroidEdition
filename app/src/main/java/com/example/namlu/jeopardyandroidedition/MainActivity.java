package com.example.namlu.jeopardyandroidedition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener, View.OnClickListener, TextWatcher{

    /*
     * @param questionsCorrect count of the number of questions answered correctly
     * @param pointsAwarded an array that tracks the questions answered correctly
     */
    int questionsCorrect = 0;
    boolean[] pointsAwarded = {false, false, false, false, false, false};

    // Reference to RadioButton
    RadioGroup questionOneGroup, questionFourGroup;

    // Reference to CheckBoxes
    CheckBox questionTwoA, questionTwoB, questionTwoC, questionTwoD,
            questionFiveA, questionFiveB, questionFiveC, questionFiveD;

    // Reference to EditTextBoxes
    EditText questionThree, questionSix;

    // Reference to Button
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        // Listener question 3
        questionThree = (EditText) findViewById(R.id.et_question_three);
        questionThree.addTextChangedListener(this);

        // Listener question 4
        questionFourGroup = (RadioGroup) findViewById(R.id.rg_question_four);
        questionFourGroup.setOnCheckedChangeListener(this);

        // Listener question 5
        questionFiveA = (CheckBox) findViewById(R.id.cb_question_five_a);
        questionFiveA.setOnCheckedChangeListener(this);

        questionFiveB = (CheckBox) findViewById(R.id.cb_question_five_b);
        questionFiveB.setOnCheckedChangeListener(this);

        questionFiveC = (CheckBox) findViewById(R.id.cb_question_five_c);
        questionFiveC.setOnCheckedChangeListener(this);

        questionFiveD = (CheckBox) findViewById(R.id.cb_question_five_d);
        questionFiveD.setOnCheckedChangeListener(this);

        // Listener question 6
        questionSix = (EditText) findViewById(R.id.et_question_six);
        questionSix.addTextChangedListener(this);

        // Listener for Submit button
        submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(this);
    }

    // Do something when CheckBoxes are ticked
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        // Questions #2 - If response is correct, set PointsAwarded to true, else set to false
        switch (compoundButton.getId()) {
            case R.id.cb_question_two_a:
            case R.id.cb_question_two_b:
                if (questionTwoA.isChecked() && questionTwoB.isChecked()) {
                    pointsAwarded[1] = true;
                } else
                    pointsAwarded[1] = false;
                break;
            case R.id.cb_question_two_c:
            case R.id.cb_question_two_d:
                pointsAwarded[1] = false;
                break;
        }

        // Questions #5 - If response is correct, set PointsAwarded to true, else set to false
        switch (compoundButton.getId()) {
            case R.id.cb_question_five_a:
            case R.id.cb_question_five_b:
            case R.id.cb_question_five_c:
            case R.id.cb_question_five_d:
                if (questionFiveA.isChecked() &&
                        questionFiveB.isChecked() &&
                        questionFiveC.isChecked() &&
                        questionFiveD.isChecked()) {
                    pointsAwarded[4] = true;
                } else {
                    pointsAwarded[4] = false;
                }
        }
    }

    // Do something when RadioBoxes are ticked
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
        // Question #1 - If response is correct, set PointsAwarded to true, else set to false
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_question_one_a:
                pointsAwarded[0] = true;
                break;
            case R.id.rb_question_one_b:
            case R.id.rb_question_one_c:
            case R.id.rb_question_one_d:
                pointsAwarded[0] = false;
                break;
        }

        // Question #4 - If response is correct, set PointsAwarded to true, else set to false
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_question_four_c:
                pointsAwarded[3] = true;
                break;
            case R.id.rb_question_four_a:
            case R.id.rb_question_four_b:
            case R.id.rb_question_four_d:
                pointsAwarded[3] = false;
                break;
        }
    }

    // Do something when Button is pressed
    @Override
    public void onClick(View view) {
        // When user clicks on 'Submit', calculate points and present Toast message with user's score
        if (view.getId() == R.id.button_submit) {
            getScore();
            Toast.makeText(this, "Answer(s) correct: " + questionsCorrect + "/" + pointsAwarded.length, Toast.LENGTH_SHORT).show();
        }
    }

    // Do something when EditText fields are used
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        // Question #3 - If user enters correct text, set PointsAwarded to true, else set to false
        String questionThreeString = questionThree.getText().toString();
        if (!TextUtils.isEmpty(questionThreeString)) {
            if (questionThreeString.equalsIgnoreCase("activity")) {
                pointsAwarded[2] = true;
            } else {
                pointsAwarded[2] = false;
            }
        }

        // Question #6 - If user enters correct text, set PointsAwarded to true, else set to false
        String questionSixString = questionSix.getText().toString();
        if (!TextUtils.isEmpty(questionSixString)) {
            if (questionSixString.equalsIgnoreCase("intent")) {
                pointsAwarded[5] = true;
            } else {
                pointsAwarded[5] = false;
            }
        }
    }

    // Get score based on number of correct responses
    void getScore() {
        // Reset correct responses to zero
        questionsCorrect = 0;

        for (int i = 0; i < pointsAwarded.length; i++) {
            if (pointsAwarded[i] == true) {
                questionsCorrect++;
            }
        }
    }
}

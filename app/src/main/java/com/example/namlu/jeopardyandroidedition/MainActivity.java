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

    static final int NUM_OF_QUESTIONS = 4;

    /*
     * @param questionsCorrect tracks the number of questions answered correctly
     * @param questionOneToggle tracks if question one
     */
    int correctResponses = 0;
    boolean questionOnePointsAwarded = false;
    boolean questionTwoPointsAwarded = false;
    boolean questionThreePointsAwarded = false;

    // Reference to RadioButton
    RadioGroup questionOneGroup;

    // Reference to CheckBoxes
    CheckBox questionTwoA, questionTwoB, questionTwoC, questionTwoD;

    // Reference to EditTextBoxes
    EditText questionThree;

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

        // Reference to question 3
        questionThree = (EditText) findViewById(R.id.et_question_three);
        questionThree.addTextChangedListener(this);

        // Listener for Submit button
        submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(this);
    }

    // Do something when CheckBoxes are ticked
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.cb_question_two_a:
            case R.id.cb_question_two_b:
                if (questionTwoA.isChecked() && questionTwoB.isChecked()) {
                    questionTwoPointsAwarded = true;
                } else
                    questionTwoPointsAwarded = false;
                break;
            case R.id.cb_question_two_c:
            case R.id.cb_question_two_d:
                questionTwoPointsAwarded = false;
                break;
        }
    }

    // Do something when RadioBoxes are ticked
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
        // If response is correct, set points awarded to true, else set to false
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_question_one_a:
                questionOnePointsAwarded = true;
                break;
            case R.id.rb_question_one_b:
            case R.id.rb_question_one_c:
            case R.id.rb_question_one_d:
                questionOnePointsAwarded = false;
                break;
        }
    }

    // Do something when Button is pressed
    @Override
    public void onClick(View view) {
        // When user clicks on 'Submit', calculate points and present Toast message with user's score
        if (view.getId() == R.id.button_submit) {
            awardPoints();
            Toast.makeText(this, "Answers correct: " + correctResponses + "/" + NUM_OF_QUESTIONS, Toast.LENGTH_SHORT).show();
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
        String questionThreeString = questionThree.getText().toString();
        if (!TextUtils.isEmpty(questionThreeString)) {
            if (questionThreeString.equalsIgnoreCase("activity")) {
                questionThreePointsAwarded = true;
            } else {
                questionThreePointsAwarded = false;
            }
        }
    }

    // Awards points based on number of correct responses
    void awardPoints() {
        // Reset correct responses to zero
        correctResponses = 0;

        if (questionOnePointsAwarded) {
            correctResponses++;
        }
        if (questionTwoPointsAwarded) {
            correctResponses++;
        }
        if (questionThreePointsAwarded) {
            correctResponses++;
        }
    }
}

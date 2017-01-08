package com.example.namlu.jeopardyandroidedition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener{

    /*
     * @param questionsCorrect tracks the number of questions answered correctly
     */
    int questionsCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Reference to RadioButton
        RadioGroup questionOneGroup;

        // Reference to CheckBox
        CheckBox questionTwoA;
        CheckBox questionTwoB;
        CheckBox questionTwoC;
        CheckBox questionTwoD;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOneGroup = (RadioGroup) findViewById(R.id.rg_question_one);
        questionOneGroup.setOnCheckedChangeListener(this);

        questionTwoA = (CheckBox) findViewById(R.id.cb_question_two_a);
        questionTwoA.setOnCheckedChangeListener(this);

        questionTwoB = (CheckBox) findViewById(R.id.cb_question_two_b);
        questionTwoB.setOnCheckedChangeListener(this);

        questionTwoC = (CheckBox) findViewById(R.id.cb_question_two_c);
        questionTwoC.setOnCheckedChangeListener(this);

        questionTwoD = (CheckBox) findViewById(R.id.cb_question_two_d);
        questionTwoD.setOnCheckedChangeListener(this);
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
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_question_one_a:
                Toast.makeText(this, "RB a selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_question_one_b:
                Toast.makeText(this, "RB b selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_question_one_c:
                Toast.makeText(this, "RB c selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_question_one_d:
                Toast.makeText(this, "RB d selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // Checks if answers given to CheckBox questions are correct
    void validateCheckBoxResponse() {

    }

    // Checks if answers given to RadioButton questions are correct
    void validateRadioButtonResponse() {

    }
}

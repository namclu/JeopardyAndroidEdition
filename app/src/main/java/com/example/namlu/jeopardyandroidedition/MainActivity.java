package com.example.namlu.jeopardyandroidedition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener{

    /*
     * @param
     */
    int questionsCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // References to buttons
        RadioGroup questionOneGroup;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOneGroup = (RadioGroup) findViewById(R.id.rg_question_one);
        questionOneGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

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
}

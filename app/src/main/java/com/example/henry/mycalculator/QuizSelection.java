package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;

import java.util.ArrayList;

public class QuizSelection extends Activity implements OnClickListener {

    int selection[] = new int[13];       //array to hold keys, key values listed in comment below
    public int numberQuestions = 5000;
    int difficulty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_selection);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, QuizSelection.class);
        MyUtils.startNoHistoryAcitivity( this, intent );
    }

    public void chooseDifficulty(View v) {
        if (v == findViewById(R.id.radio_difficulty_low)) {
            difficulty = 0;
        } else if (v == findViewById(R.id.radio_difficulty_medium)) {
            difficulty = 1;
        } else if (v == findViewById(R.id.radio_difficulty_high)) {
            difficulty = 2;
        }
        //Log.i("diffculty:", (new Integer(difficulty)).toString());
    }

    public void ButtonStartQuiz(View v) {
        EditText makeError = (EditText) findViewById(R.id.errorDisplay);
        int empty = 0;
        if (v.getId() == R.id.btnStartQuizActivity) {
            Intent i = new Intent(QuizSelection.this, Quiz.class);
            i.putExtra("numberQuestions", numberQuestions);        //gives user desired test length to test activity
            i.putExtra("selection", selection) ;                    //gives array of keys to test activity
            i.putExtra("difficulty", difficulty) ;
            for (int index = 0; index < 11; index++) {
                if (selection[index] != 0) {            //checks that user clicked a checkbox before generating next activity
                    empty = 1;
                    break;
                }
            }
            if (empty == 1) {
                MyUtils.startNoHistoryAcitivity( this , i );
            } else {
                makeError.setError("You must check one");
            }
        }


    }


    /*
    Add to the array list of Integers KEY
    1. Decimal to Binary conversion
    2. Binary to Decimal conversion
    3. Decimal to Octal conversion
    4. Octal to Decimal conversion
    5. Binary to Octal conversion
    6. Octal to Binary conversion
    7. Decimal to Hexadecimal conversion
    8. Hexadecimal to Decimal conversion
    9. Binary to Hexadecimal conversion
    10. Hexadecimal to Binary conversion
    11. Octal to Hexadecimal conversion
    12. Hexadecimal to Octal conversion
    length-1.(last one) Difficulty
     */

    //Depending on what check box is selected add the key value into an array
    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.Decimal_Binary:
                if (checked) {
                    selection[0] = 1;
                    selection[1] = 2;
                } else {
                    selection[0] = 0;
                    selection[1] = 0;
                }
                break;

            case R.id.Decimal_Octal:
                if (checked) {
                    selection[2] = 3;
                    selection[3] = 4;
                } else {
                    selection[2] = 0;
                    selection[3] = 0;
                }
                break;

            case R.id.Binary_Octal:
                if (checked) {
                    selection[4] = 5;
                    selection[5] = 6;
                } else {
                    selection[4] = 0;
                    selection[5] = 0;
                }
                break;

            case R.id.Decimal_Hexadecimal:
                if (checked) {
                    selection[6] = 7;
                    selection[7] = 8;
                } else {
                    selection[6] = 0;
                    selection[7] = 0;
                }
                break;

            case R.id.Binary_Hexadecimal:
                if (checked) {
                    selection[8] = 9;
                    selection[9] = 10;
                } else {
                    selection[8] = 0;
                    selection[9] = 0;
                }
                break;

            case R.id.Octal_Hexadecimal:
                if (checked) {
                    selection[10] = 11;
                    selection[11] = 12;
                } else {
                    selection[10] = 0;
                    selection[11] = 0;
                }
                break;
        }
    }

    //int numberQuestions = 5000;

    public void Qnum(View view) {
        // is the button checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Which radio button clicked?
        switch (view.getId()) {      // this makes it so only one radiobutton can be selected
            case R.id.SixQs:
                if (checked) {
                    numberQuestions = 6;
                    // 6 questions
                }
                break;
            case R.id.TwelveQs:
                if (checked) {
                    numberQuestions = 12;
                    // 12 questions
                }
                break;
            case R.id.twenty4Qs:
                if (checked) {
                    numberQuestions = 24;
                    // 24 questions
                }
                break;
            case R.id.Endless:
                if (checked)
                    numberQuestions = 5000;
                    break;
        }
    }
}
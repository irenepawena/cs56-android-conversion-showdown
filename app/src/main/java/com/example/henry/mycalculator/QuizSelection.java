package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;

import java.util.ArrayList;

public class QuizSelection extends Activity implements OnClickListener {

    ArrayList<Integer> selection = new ArrayList<Integer>();
    public int numberQuestions = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_selection);
        //Intent i = new Intent(QuizSelection.this, Quiz.class);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, QuizSelection.class);
        //intent.putStringArrayListExtra("selection", selection);
        startActivity(intent);
    }

    public void ButtonStartQuiz(View v) {
        if (v.getId() == R.id.btnStartQuizActivity) {
            Intent i = new Intent(QuizSelection.this, Quiz.class);
            i.putExtra("numberQuestions", numberQuestions);
            startActivity(i);
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
     */

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.Decimal_Binary:
                if (checked) {
                    selection.add(1);
                    selection.add(2);
                } else {
                    selection.remove(1);
                    selection.remove(2);
                }
                break;

            case R.id.Decimal_Octal:
                if (checked) {
                    selection.add(3);
                    selection.add(4);
                } else {
                    selection.remove(3);
                    selection.remove(4);
                }
                break;

            case R.id.Binary_Octal:
                if (checked) {
                    selection.add(5);
                    selection.add(6);
                } else {
                    selection.remove(5);
                    selection.remove(6);
                }
                break;

            case R.id.Decimal_Hexadecimal:
                if (checked) {
                    selection.add(7);
                    selection.add(8);
                } else {
                    selection.remove(7);
                    selection.remove(8);
                }
                break;

            case R.id.Binary_Hexadecimal:
                if (checked) {
                    selection.add(9);
                    selection.add(10);
                } else {
                    selection.remove(9);
                    selection.remove(10);
                }
                break;

            case R.id.Octal_Hexadecimal:
                if (checked) {
                    selection.add(11);
                    selection.add(12);
                } else {
                    selection.remove(11);
                    selection.remove(12);
                }
                break;
        }
    }

    //int numberQuestions = 5000;

    public void Qnum(View view) {
        // is the button checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Which radio button clicked?
        switch (view.getId()) {
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
                    // Endless
                    break;
        }

    }



}
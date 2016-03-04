package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Main3Activity extends Activity implements OnClickListener {

    ArrayList<String> selection = new ArrayList<String>();
    public int numberQuestions = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Intent i = new Intent(Main3Activity.this, Main4Activityquiz.class);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        //intent.putStringArrayListExtra("selection", selection);
        startActivity(intent);
    }

    public void ButtonStartQuiz(View v) {
        if (v.getId() == R.id.btnStartQuizActivity) {
            Intent i = new Intent(Main3Activity.this, Main4Activityquiz.class);
            i.putExtra("numberQuestions", numberQuestions);
            startActivity(i);
        }
    }

    //ArrayList<String> selection = new ArrayList<String>();

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.Decimal_Binary:
                if (checked) {
                    selection.add("Decimal_Binary");
                } else {
                    selection.remove("Decimal_Binary");
                }
                break;

            case R.id.Decimal_Octal:
                if (checked) {
                    selection.add("Decimal_Octal");
                } else {
                    selection.remove("Decimal_Octal");
                }
                break;

            case R.id.Binary_Octal:
                if (checked) {
                    selection.add("Binary_Octal");
                } else {
                    selection.remove("Binary_Octal");
                }
                break;

            case R.id.Decimal_Hexadecimal:
                if (checked) {
                    selection.add("Decimal_Hexadecimal");
                } else {
                    selection.remove("Decimal_Hexadecimal");
                }
                break;

            case R.id.Binary_Hexadecimal:
                if (checked) {
                    selection.add("Binary_Hexadecimal");
                } else {
                    selection.remove("Binary_Hexadecimal");
                }
                break;

            case R.id.Octal_Hexadecimal:
                if (checked) {
                    selection.add("Octal_Hexadecimal");
                } else {
                    selection.remove("Octal_Hexadecimal");
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
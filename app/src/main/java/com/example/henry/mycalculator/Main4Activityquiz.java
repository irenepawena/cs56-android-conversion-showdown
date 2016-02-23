package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Main4Activityquiz extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_activityquiz);
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, Main4Activityquiz.class);

        // Calling another activity Main4Activitytest start the quiz

        startActivity(intent);
    }


    String myString = "0";
    public void TestResult(View view){
        int binary = Integer.parseInt(myString,2);
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);
        int binaryanswer = Integer.parseInt(answer.getText().toString());
        if(binary == binaryanswer){
            respond.setText("Correct");
        } else {
            respond.setText("Incorrect");
        }

        Random rand = new Random();
        int number = rand.nextInt(4097);
        TextView myText = (TextView)findViewById(R.id.decimal);
        String myString = String.valueOf(number);
        myText.setText(myString);
    }


}

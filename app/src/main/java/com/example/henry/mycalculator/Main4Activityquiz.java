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


    public void TestResult(View view){
        // Take number from text field and convert it to an integer
        TextView myText = (TextView)findViewById(R.id.decimal);
        String TxtString = myText.getText().toString();
        int binary = Integer.parseInt(TxtString);

        // Take user answer from text field and convert it to an integer
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        int binaryanswer = Integer.parseInt(answer.getText().toString(), 2);
        String binarytext = answer.getText().toString();

        // compare the answer to the actual value
        TextView test = (TextView)findViewById(R.id.test);
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);
        if(binary == binaryanswer){
            respond.setText(R.string.correct);
            test.setText(TxtString + " is the same as" + binarytext);
        } else {
            respond.setText(R.string.incorrect);
            test.setText("Keep Trying");
        }

    }


    public void changeDecimal(View view){
        // create a Random number for the next problem
        TextView myText = (TextView)findViewById(R.id.decimal);
        Random rand = new Random();
        int number = rand.nextInt(4097);
        myText.setText(String.valueOf(number));
    }


}

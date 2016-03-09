package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Quiz extends Activity implements OnClickListener {

    int numberQuestions = 0;       // test length
    float result = 0;              // for calculating percentage correct

    ArrayList<Integer> arrayOfKeys = new ArrayList<Integer>();   //stores all keys
    int key = 0;     //determines type of problem
     /*
    KEY
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

    int length = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        int selectedOptions[] = getIntent().getIntArrayExtra("selection");
        numberQuestions = getIntent().getIntExtra("numberQuestions", -1);

        for (int j = 0; j < 11; j++) {
            if (selectedOptions[j] != 0) {
                arrayOfKeys.add(selectedOptions[j]);
            }
        }
        length = arrayOfKeys.size();

        TextView problemString = (TextView) findViewById(R.id.convertstring);  // variable to change problem String
        TextView problemNumber = (TextView) findViewById(R.id.convertThis);    // variable to change problem number
        TextView changeQuestion = (TextView) findViewById(R.id.textView3);     // problem description

        if (selectedOptions[0] == 1) {
            key = 1;      //Decimal to Binary conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
            changeQuestion.setText(R.string.questionKey1);
        }
        if (selectedOptions[2] == 3) {
            key = 3;      //Decimal to Octal conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
            changeQuestion.setText(R.string.questionKey3);
        }
        if (selectedOptions[4] == 5) {
            key = 5;      //Binary to Octal conversion
            problemString.setText("Binary:");
            problemNumber.setText("101");
            changeQuestion.setText(R.string.questionKey5);
        }

        if (selectedOptions[6] == 7) {
            key = 7;      //Decimal to Hexadecimal conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
            changeQuestion.setText(R.string.questionKey7);
        }
        if (selectedOptions[8] == 9) {
            key = 9;      //Binary to Hexadecimal conversion
            problemString.setText("Binary:");
            problemNumber.setText("101");
            changeQuestion.setText(R.string.questionKey9);
        }
        if (selectedOptions[10] == 11) {
            key = 11;      //Octal to Hexadecimal conversion
            problemString.setText("Octal:");
            problemNumber.setText("03");
            changeQuestion.setText(R.string.questionKey11);
        }

    }


    public void onClick(View view) {
        Intent intent = new Intent(this, Quiz.class);
        // Calling another activity Main4Activitytest start the quiz
        startActivity(intent);
    }


    //int length = arrayOfKeys.size();    //variable to help make the random selection of index in array of keys
    int radix = 10;

    int[] keysArray = new int[arrayOfKeys.size()];

    public void TestResult(View view) {

        if (key == 1 || key == 6 || key == 10) {
            radix = 2;
        }
        if (key == 3 || key == 5 || key == 12) {
            radix = 8;
        }
        if (key == 2 || key == 4 || key == 8) {
            radix = 10;
        }
        if (key == 7 || key == 9 || key == 11) {
            radix = 16;
        }

        // Take number from text field and convert it to an integer
        TextView myText = (TextView) findViewById(R.id.convertThis);
        String TxtString = myText.getText().toString();

        int ProblemValue = 0;
        if (key == 1 || key == 3 || key == 7) {
            ProblemValue = Integer.parseInt(TxtString,10);           //convert number displayed to be converted to decimal
        }
        if (key == 2 || key == 5 || key == 9){
            ProblemValue = Integer.parseInt(TxtString, 2);
        }
        if (key == 4 || key == 6 || key == 11){
            ProblemValue = Integer.parseInt(TxtString, 8);
        }
        if (key == 8 || key == 10 || key == 12){
            ProblemValue = Integer.parseInt(TxtString, 16);
        }

        //Respond prompts
        TextView test = (TextView) findViewById(R.id.test);              // "problem number" is the same as "answer"
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);   // says Correct or Incorrect

        // Take user answer from text field and make it a string
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        String sAnswer = answer.getText().toString();

        //checks if a value is entered and that it is an appropriate value
        if (TextUtils.isEmpty(sAnswer)) {
            answer.setError("Please input a value.");
            return;
        }

        int checkValueEntered = Integer.parseInt(answer.getText().toString());

        if (radix == 2 && checkValueEntered % 10 > 1) {
            answer.setError("Incorrect number type.");
            return;
        }
        if (radix == 8 && checkValueEntered % 9 == 0){
            answer.setError("Incorrect number type.");
        }
        // above checks if value is entered and that it is an appropriate value


        else {
            int userAnswer;
            if(key == 7 || key == 9 || key == 11){
                userAnswer = Integer.parseInt(sAnswer, 16);
            }
            else{
                userAnswer = Integer.parseInt(answer.getText().toString(), radix);
            }
            //String answerUser = answer.getText().toString();

            //denominator always increases
            TextView denominator = (TextView) findViewById(R.id.NumAttempt);
            int den = Integer.parseInt(denominator.getText().toString());
            den = den + 1;
            denominator.setText(String.valueOf(den));

            TextView numerator = (TextView) findViewById(R.id.NumCorrect);
            int num = Integer.parseInt(numerator.getText().toString());

            // compare the answer to the actual value
            if (ProblemValue == userAnswer) {
                num = num + 1;
                numerator.setText(String.valueOf(num));

                respond.setText(R.string.correct);
                test.setText(TxtString + " is the same as " + sAnswer);
            } else {

                respond.setText(R.string.incorrect);
                test.setText(TxtString + "not same as" + sAnswer);
            }
            // above compares answer to actual value

            // Makes the progress percent
            TextView de = (TextView) findViewById(R.id.NumAttempt);
            int d = Integer.parseInt(de.getText().toString());
            float deno = (float) d;

            TextView nu = (TextView) findViewById(R.id.NumCorrect);
            int n = Integer.parseInt(nu.getText().toString());
            float numer = (float) n;

            result = (numer / deno) * 100;
            TextView percent = (TextView) findViewById(R.id.PercentCorrect);
            percent.setText(String.valueOf(result + " %"));
            // above makes progress percent

            // This part ends the test depending on test length asked for
            if (den == numberQuestions) {
                Intent activity = new Intent(this, ScoreReport.class);
                activity.putExtra("result", result);
                startActivity(activity);
            }
            // above stops test depending on requested length


        }
    }

    //int newKey = key;
    int IndexArrayKeys = 0;

    public void changeNumber(View view) {

        if (IndexArrayKeys == length-1) {
            IndexArrayKeys = 0;
            //key = arrayOfKeys.get(IndexArrayKeys);
        }
        else{
            IndexArrayKeys = IndexArrayKeys + 1;
            //key = arrayOfKeys.get(IndexArrayKeys);

        }
        key = arrayOfKeys.get(IndexArrayKeys);


        if (key == 1 || key == 3 || key == 7){
            TextView change = (TextView) findViewById(R.id.convertThis);
            Random rand = new Random();
            int number = rand.nextInt(200);
            change.setText(String.valueOf(number));

            TextView problemString = (TextView) findViewById(R.id.convertstring);
            problemString.setText("Decimal:");

            TextView changeQuestion = (TextView) findViewById(R.id.textView3);

            if(key == 1){ changeQuestion.setText(R.string.questionKey1); }
            if(key == 3){ changeQuestion.setText(R.string.questionKey3); }
            if(key == 7){ changeQuestion.setText(R.string.questionKey7); }

        }
        if(key == 2 || key == 5 || key == 9){
            //radix 2
            TextView change = (TextView) findViewById(R.id.convertThis);
            Random rand = new Random();
            int number = rand.nextInt(200);
            String b = Integer.toBinaryString(number);
            change.setText(b);

            TextView problemString = (TextView) findViewById(R.id.convertstring);
            problemString.setText("Binary:");

            TextView changeQuestion = (TextView) findViewById(R.id.textView3);

            if(key == 2){ changeQuestion.setText(R.string.questionKey2); }
            if(key == 5){ changeQuestion.setText(R.string.questionKey5); }
            if(key == 9){ changeQuestion.setText(R.string.questionKey9); }

        }
        if(key == 4 || key == 6 || key == 11){
            //radix 8
            TextView change = (TextView) findViewById(R.id.convertThis);
            Random rand = new Random();
            int number = rand.nextInt(200);
            String b = Integer.toOctalString(number);
            change.setText(b);

            TextView problemString = (TextView) findViewById(R.id.convertstring);
            problemString.setText("Octal:");

            TextView changeQuestion = (TextView) findViewById(R.id.textView3);

            if(key == 4){ changeQuestion.setText(R.string.questionKey4); }
            if(key == 6){ changeQuestion.setText(R.string.questionKey6); }
            if(key == 11){ changeQuestion.setText(R.string.questionKey11); }

        }
        if(key == 8 || key == 10 || key == 12) {
            //radix 16
            TextView change = (TextView) findViewById(R.id.convertThis);
            Random rand = new Random();
            int number = rand.nextInt(200);
            String b = Integer.toHexString(number);
            change.setText(b);

            TextView problemString = (TextView) findViewById(R.id.convertstring);
            problemString.setText("Hexadecimal:");

            TextView changeQuestion = (TextView) findViewById(R.id.textView3);

            if(key == 8){ changeQuestion.setText(R.string.questionKey8); }
            if(key == 10){ changeQuestion.setText(R.string.questionKey10); }
            if(key == 12){ changeQuestion.setText(R.string.questionKey12); }
        }



    }

    public void Abort(View view){
        Intent activity = new Intent(this, ScoreReport.class);
        activity.putExtra("result", result);
        startActivity(activity);
    }


}

package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends Activity implements OnClickListener {

//int selectedOptions[] = new int[12];
int numberQuestions = 0;
float result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        int selectedOption[] = getIntent().getIntArrayExtra("selection");
        numberQuestions = getIntent().getIntExtra("numberQuestions", -1);
        //ArrayList<String> step = getIntent().getExtras().getStringArrayList("selection");
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, Quiz.class);
        // Calling another activity Main4Activitytest start the quiz
        startActivity(intent);
    }

    public void TestResult(View view) {

        // Take number from text field and convert it to an integer
        TextView myText = (TextView) findViewById(R.id.decimal);
        String TxtString = myText.getText().toString();
        int binary = Integer.parseInt(TxtString);

        //Respond prompts
        TextView test = (TextView) findViewById(R.id.test);
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);

        // Take user answer from text field and convert it to binary number then an int
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        String sAnswer = answer.getText().toString();

        //checks if a value is entered and that it is an appropriate value
        if(TextUtils.isEmpty(sAnswer)) {
            answer.setError("Please input a value.");
            return;
        }

        int checkBinary = Integer.parseInt(answer.getText().toString());

        if (checkBinary % 10 > 1 ) {
            answer.setError("That is not a binary number.");
            return;
        }
        // above checks if value is entered and that it is an appropriate value

        else {
            int binaryanswer = Integer.parseInt(answer.getText().toString(), 2);
            String binarytext = answer.getText().toString();

            //denominator always increases
            TextView denominator = (TextView) findViewById(R.id.NumAttempt);
            int den = Integer.parseInt(denominator.getText().toString());
            den = den + 1;
            denominator.setText(String.valueOf(den));

            TextView numerator = (TextView) findViewById(R.id.NumCorrect);
            int num = Integer.parseInt(numerator.getText().toString());

            // compare the answer to the actual value
            if (binary == binaryanswer) {
                num = num + 1;
                numerator.setText(String.valueOf(num));

                respond.setText(R.string.correct);
                test.setText(TxtString + " is the same as " + binarytext);
            } else {

                respond.setText(R.string.incorrect);
                test.setText("Please Try Again!");
            }
            // above compares answer to actual value

            // Makes the progress percent
            TextView de = (TextView) findViewById(R.id.NumAttempt);
            int d = Integer.parseInt(de.getText().toString());
            float deno = (float) d;

            TextView nu = (TextView) findViewById(R.id.NumCorrect);
            int n = Integer.parseInt(nu.getText().toString());
            float numer = (float) n;

            result = (numer/deno)*100;
            TextView percent = (TextView) findViewById(R.id.PercentCorrect);
            percent.setText(String.valueOf(result + " %"));
            // above makes progress percent

            // This part ends the test depending on test length asked for
            if(den == numberQuestions){
                Intent activity = new Intent(this, ScoreReport.class);
                activity.putExtra("result", result);
                startActivity(activity);
            }
            // above stops test depending on requested length
        }
    }

    public void changeDecimal(View view) {
        // create a Random number for the next problem
        TextView myText = (TextView) findViewById(R.id.decimal);
        Random rand = new Random();
        int number = rand.nextInt(4097);
        myText.setText(String.valueOf(number));

    }



}

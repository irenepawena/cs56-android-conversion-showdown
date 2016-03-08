package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        int selectedOptions[] = getIntent().getIntArrayExtra("selection");
        numberQuestions = getIntent().getIntExtra("numberQuestions", -1);

        for (int j = 0; j < 11; j++){
            if (selectedOptions[j] != 0) {
                arrayOfKeys.add(selectedOptions[j]);
            }
        }

        TextView problemString = (TextView) findViewById(R.id.convertstring);  // variable to change problem String
        TextView problemNumber = (TextView) findViewById(R.id.convertThis);    // variable to change problem number

        if (selectedOptions[0] == 1){
            key = 1;      //Decimal to Binary conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
        }
        if (selectedOptions[2] == 3){
            key = 3;      //Decimal to Octal conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
        }
        if(selectedOptions[4] == 5){
            key = 5;      //Binary to Octal conversion
            problemString.setText("Binary:");
            problemNumber.setText("101");
        }

        if(selectedOptions[6] == 7){
            key = 7;      //Decimal to Hexadecimal conversion
            problemString.setText("Decimal:");
            problemNumber.setText("5");
        }
        if(selectedOptions[8] == 9){
            key = 9;      //Binary to Hexadecimal conversion
            problemString.setText("Binary:");
            problemNumber.setText("101");
        }
        if(selectedOptions[10] == 11){
            key = 11;      //Octal to Hexadecimal conversion
            problemString.setText("Octal:");
            problemNumber.setText("03");
        }

    }



    public void onClick(View view) {
        Intent intent = new Intent(this, Quiz.class);
        // Calling another activity Main4Activitytest start the quiz
        startActivity(intent);
    }


    int length = arrayOfKeys.size();    //variable to help make the random selection of index in array of keys
    int radix = 10;

    public void TestResult(View view) {

        if(key == 1 || key == 3 || key == 7){
            radix = 10;
        }
        if(key == 2 || key == 5 || key == 9){
            radix = 2;
        }

        // Take number from text field and convert it to an integer
        TextView myText = (TextView) findViewById(R.id.convertThis);
        String TxtString = myText.getText().toString();
        /*Todo: use the array values to determine whether the problem number needs to be converted to
         a decimal for comparison (use an if)
        */

        int binary = Integer.parseInt(TxtString);                    //convert number displayed to be converted to decimal

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

            TextView change = (TextView) findViewById(R.id.convertThis);
            Random rand = new Random();
            int number = rand.nextInt(200);
            change.setText(String.valueOf(number));

        }
    }

    public void changeDecimal(View view) {
        // create a Random number for the next problem
        TextView myText = (TextView) findViewById(R.id.convertThis);
        Random rand = new Random();
        int number = rand.nextInt(4097);
        myText.setText(String.valueOf(number));

    }

    public void Abort(View view){
        Intent activity = new Intent(this, ScoreReport.class);
        activity.putExtra("result", result);
        startActivity(activity);
    }


}

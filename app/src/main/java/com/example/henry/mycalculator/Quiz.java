package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Class that deals with the Quiz you can customize in Quiz Selection
public class Quiz extends Activity implements OnClickListener {

    int numberQuestions = 0;       // test length
    public static float result = 0;              // for calculating percentage correct
    ArrayList<Integer> arrayOfKeys = new ArrayList<>();   //stores all keys
    int key = 0;     //determines type of problem
    int difficulty = 1;
    final static int[] range_min = new int[]{0, 200, 1000};
    final static int[] range_max = new int[]{200, 1000, 5000};
    int IndexArrayKeys = 0;    // variable to track index of the ArrayList with key values
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


    //Following variables are defined by dummyindex
    int length = 0;
    final public static int DEC_TO_BIN = 1;
    final public static int BIN_TO_DEC = 2;
    final public static int DEC_TO_OCT = 3;
    final public static int OCT_TO_DEC = 4;
    final public static int BIN_TO_OCT = 5;
    final public static int OCT_TO_BIN = 6;
    final public static int DEC_TO_HEX = 7;
    final public static int HEX_TO_DEC = 8;
    final public static int BIN_TO_HEX = 9;
    final public static int HEX_TO_BIN = 10;
    final public static int OCT_TO_HEX = 11;
    final public static int HEX_TO_OCT = 12;
    static public String[] key2type = new String[]{
            "",
            "DEC_TO_BIN",
            "BIN_TO_DEC",
            "DEC_TO_OCT",
            "OCT_TO_DEC",
            "BIN_TO_OCT",
            "OCT_TO_BIN",
            "DEC_TO_HEX",
            "HEX_TO_DEC",
            "BIN_TO_HEX",
            "HEX_TO_BIN",
            "OCT_TO_HEX",
            "HEX_TO_OCT"

    };
    int[] scoreBoardByKey = new int[13];
    private ArrayList<Question> wrongQuestions = new ArrayList<>();

    private void initializeScoreBoard() {
        for (int i = 0; i < scoreBoardByKey.length; ++i) {
            scoreBoardByKey[i] = 0;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 0:
                return;
            case 1:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeScoreBoard();
        setContentView(R.layout.quiz);

            int selectedOptions[] = getIntent().getIntArrayExtra("selection");  //receives array of key values
            numberQuestions = getIntent().getIntExtra("numberQuestions", -1);   //receives user desired test length
            difficulty = getIntent().getIntExtra("difficulty", 0);

            //adds key values taken from selection activity into ArrayList
            for (int j = 0; j < 11; j++) {
                if (selectedOptions[j] != 0) {
                    arrayOfKeys.add(selectedOptions[j]);
                }
            }
            length = arrayOfKeys.size();

            TextView problemString = (TextView) findViewById(R.id.convertstring);  // variable to change problem String
            TextView problemNumber = (TextView) findViewById(R.id.convertThis);    // variable to change problem number
            TextView questionDescription = (TextView) findViewById(R.id.textView3);     // problem description
            EditText editkeyboard = (EditText) findViewById(R.id.AnswerField);     //allows keyboard type to change for the problem
            Button startSwiperButton = (Button) findViewById(R.id.startSwiperButton);
            startSwiperButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Quiz.this, SwiperCalculatorActivity.class);
                    startActivityForResult(intent, 0);
                }
            });
            if (selectedOptions[0] == 1) {
                key = 1;      //Decimal to Binary conversion
                problemString.setText("Decimal:");
                questionDescription.setText(R.string.questionKey1);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);    //keyboard only numbers
            }
            if (selectedOptions[2] == 3) {
                key = 3;      //Decimal to Octal conversion
                problemString.setText("Decimal:");
                questionDescription.setText(R.string.questionKey3);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (selectedOptions[4] == 5) {
                key = 5;      //Binary to Octal conversion
                problemString.setText("Binary:");
                questionDescription.setText(R.string.questionKey5);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (selectedOptions[6] == 7) {
                key = 7;      //Decimal to Hexadecimal conversion
                problemString.setText("Decimal:");
                questionDescription.setText(R.string.questionKey7);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);     //keyboard has letters & numbers
            }
            if (selectedOptions[8] == 9) {
                key = 9;      //Binary to Hexadecimal conversion
                problemString.setText("Binary:");
                questionDescription.setText(R.string.questionKey9);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);
            }
            if (selectedOptions[10] == 11) {
                key = 11;      //Octal to Hexadecimal conversion
                problemString.setText("Octal:");
                questionDescription.setText(R.string.questionKey11);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);
            }

            changeNumber(null);
        }


    public void onClick(View view) {
        Intent intent = new Intent(this, Quiz.class);
        // Calling another activity Main4Activitytest start the quiz
        startActivityForResult( intent, 1 );
    }

    int radix = 10;   //default value for radix to be manipulated

    private void set_input_error(TextView answer, int radix) {
        if (answer.getText().toString().equals("")) {
            answer.setError("Please input a value");
        }
        if (radix == 2) {
            answer.setError("Binary is only 1 and 0");
        }
        if (radix == 8) {
            answer.setError("Octal doesn't have 8 or 9");
        }
        // above checks if value is entered and that it is an appropriate value
        if (radix == 16) {
            answer.setError("Hex number format wrong");
        }

    }

    private void set_input_error(int error_code, TextView answer) {
        switch (error_code) {
            case (0):
                answer.setError("number too large");
        }
    }


    public void TestResult(View view) {
        MyUtils.hideSoftKeyBoard(view, (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE));
        //set the radix based on key, user entry determines the radix number
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
        int fromBase = -1;
        //Below: takes number that user needs to convert and makes it a decimal to compare to user answer
        if (key == 1 || key == 3 || key == 7) {
            ProblemValue = Integer.parseInt(TxtString, 10);
            fromBase = 10;
        }
        if (key == 2 || key == 5 || key == 9) {
            ProblemValue = Integer.parseInt(TxtString, 2);
            fromBase = 2;
        }
        if (key == 4 || key == 6 || key == 11) {
            ProblemValue = Integer.parseInt(TxtString, 8);
            fromBase = 8;
        }
        if (key == 8 || key == 10 || key == 12) {
            ProblemValue = Integer.parseInt(TxtString, 16);
            fromBase = 16;
        }
        //depending on problem type, convert problem number to decimal

        //Respond prompts
        TextView test = (TextView) findViewById(R.id.test);              // "problem number" is the same as "answer"
        TextView respond = (TextView) findViewById(R.id.RightOrWrong);   // says Correct or Incorrect

        // Take user answer from text field and make it a string
        EditText answer = (EditText) findViewById(R.id.AnswerField);
        String sAnswer = answer.getText().toString();
        try {
            if (!MyUtils.sanity_check(sAnswer, radix)) {
                set_input_error(answer, radix);
                return;
            }
        } catch (IntOverFlow e) {
            set_input_error(0, answer);
            return;
        }

        //user Answer is the answer from the user.
        int userAnswer;
        userAnswer = Integer.parseInt(sAnswer, radix);
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
            scoreBoardByKey[key] += 1;
            numerator.setText(String.valueOf(num));

            respond.setText(R.string.correct);
            test.setText(TxtString + " is the same as " + sAnswer);
        } else {

            respond.setText(R.string.incorrect);
            test.setText(TxtString + " not same as " + sAnswer);
            String origin = ((TextView) findViewById(R.id.convertThis)).getText().toString();
            String target = "";
            try {
                target = (new Converter(origin, fromBase)).toBase(radix);
            } catch (IntOverFlow e) {

            }
            wrongQuestions.add(new Question(
                    origin,
                    target,
                    key2type[key]
            ));
        }
        // above compares answer to actual value

        Float attempts = (float) den;
        Float correct = (float) num;
        result = (correct/attempts) * 100;
        TextView percent = (TextView) findViewById(R.id.PercentCorrect);
        percent.setText(String.valueOf(result + " %"));
        // above makes progress percent

        // This part ends the test depending on test length asked for
        if (den == numberQuestions) {
            endQuiz();
        }
        // above stops test depending on requested length

        changeNumber(null);    //change the problem type/number after entering answer
    }

    private void parcelWrongQuestions(Intent intent) {
        String[] from = new String[wrongQuestions.size()];
        String[] to = new String[from.length];
        String[] questionType = new String[from.length];
        for (int i = 0; i < wrongQuestions.size(); ++i) {
            from[i] = wrongQuestions.get(i).getFrom();
            to[i] = wrongQuestions.get(i).getTo();
            questionType[i] = wrongQuestions.get(i).getQuestionType();
        }
        intent.putExtra("from", from);
        intent.putExtra("to", to);
        intent.putExtra("questionType", questionType);
    }


    private void endQuiz() {
        Intent activity = new Intent(this, ScoreReport.class);
        activity.putExtra("result", result);
        activity.putExtra("scoreBoardByKey", scoreBoardByKey);
        activity.putExtra("arrayOfKeys", new ArrayList<Integer>(arrayOfKeys));
        activity.putExtra("wrongQuestions", wrongQuestions);
        //parcelWrongQuestions( activity );
        MyUtils.startNoHistoryAcitivity(this, activity);
        //startActivity( activity );
    }

    public int generateQuestionNumber() {
        int min_num = range_min[difficulty];
        int max_num = range_max[difficulty];
        int res = (int) (Math.random() * (max_num - min_num)) + min_num;
        return res;

    }

    public void changeNumber(View view) {
        /*
        Sorry, following codes are restructured for initial random number.
        if (IndexArrayKeys == length-1) {  //variable length created in onCreate method, tells length of ArrayList
            IndexArrayKeys = 0;            //make sure that when changing key/problem type you don't go out of bounds
        }
        else{ IndexArrayKeys = IndexArrayKeys + 1; }  //changes the key/problem type
        */
        key = arrayOfKeys.get(IndexArrayKeys);
        IndexArrayKeys = (IndexArrayKeys + 1) % length;

        EditText editkeyboard = (EditText) findViewById(R.id.AnswerField);      //allows change of keyboard when user clicks AnswerField
        TextView questionDescription = (TextView) findViewById(R.id.textView3);      //allows change of question phrase at the top
        TextView problemString = (TextView) findViewById(R.id.convertstring);   //allows change of string in format "NumberType:"

        TextView change = (TextView) findViewById(R.id.convertThis);    //allows change of number to be converted
        Random rand = new Random();                                     //need this to make a random number
        int number = generateQuestionNumber();                                 //assign random number to variable int

        if (key == 1 || key == 3 || key == 7) {
            //radix 10
            //Decimal to Binary/Octal/Hex
            change.setText(String.valueOf(number));  //changes number to be converted to Decimal
            problemString.setText("Decimal:");

            if (key == 1) {
                questionDescription.setText(R.string.questionKey1);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }        //makes the user keyboard only numbers
            if (key == 3) {
                questionDescription.setText(R.string.questionKey3);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 7) {
                questionDescription.setText(R.string.questionKey7);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);
            }          //makes user keyboard allow letters
        }

        if (key == 2 || key == 5 || key == 9) {
            //radix 2
            //Binary to Decimal/Octal/Hex
            String b = Integer.toBinaryString(number);
            change.setText(b);                       //changes number to be converted to Binary
            problemString.setText("Binary:");

            if (key == 2) {
                questionDescription.setText(R.string.questionKey2);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 5) {
                questionDescription.setText(R.string.questionKey5);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 9) {
                questionDescription.setText(R.string.questionKey9);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);
            }

        }
        if (key == 4 || key == 6 || key == 11) {
            //radix 8
            //Octal to Decimal/Binary/Hex
            String b = Integer.toOctalString(number);
            change.setText(b);                      //changes number to be converted to Octal
            problemString.setText("Octal:");

            if (key == 4) {
                questionDescription.setText(R.string.questionKey4);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 6) {
                questionDescription.setText(R.string.questionKey6);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 11) {
                questionDescription.setText(R.string.questionKey11);
                editkeyboard.setInputType(InputType.TYPE_CLASS_TEXT);
            }

        }
        if (key == 8 || key == 10 || key == 12) {
            //radix 16
            //Hex to Decimal/Binary/Octal
            String b = Integer.toHexString(number);
            change.setText(b);                    //changes number to be converted to Hex
            problemString.setText("Hexadecimal:");

            if (key == 8) {
                questionDescription.setText(R.string.questionKey8);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 10) {
                questionDescription.setText(R.string.questionKey10);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
            if (key == 12) {
                questionDescription.setText(R.string.questionKey12);
                editkeyboard.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        }
    }

    public void Abort(View view) {
        endQuiz();
    }


}

package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.sourceforge.jeval.EvaluationException;

/**
 * Created by UMARU on 7/15/2016.
 */
public class ExpressionActivity extends Activity {

    //This class is the activy part of the Expression Calculator
    private Button evalButton;
    private TextView evalResult;
    private EditText evalInput;
    private ExpressionCalculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.expression_activity );
        evalButton = (Button) findViewById( R.id.evalButton );
        evalResult = (TextView) findViewById( R.id.evalResult);
        evalInput =  (EditText) findViewById( R.id.evalInput);
        calculator = new ExpressionCalculator();
        evalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = evalInput.getText().toString();
                try {
                    String result = calculator.eval(exp);
                    evalResult.setText(result);
                } catch (EvaluationException e) {
                    evalResult.setText("EXPRESSION ERROR");
                    evalInput.setError("wrong format ");
                }
                MyUtils.hideSoftKeyBoard( v, (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE) );
            }
        });
    }
}





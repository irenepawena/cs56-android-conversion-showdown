package com.example.henry.mycalculator;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.sourceforge.jeval.EvaluationException;

/**
 * Created by UMARU on 7/27/2016.
 */
public class ExpressionCaculatorFragment extends android.support.v4.app.Fragment {
    private Button evalButton;
    private TextView evalResult;
    private EditText evalInput;
    private ExpressionCalculator calculator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setContentView( R.layout.expression_activity );
        View res_view = inflater.inflate(R.layout.expression_activity, container, false);
        evalButton = (Button) res_view.findViewById( R.id.evalButton );
        evalResult = (TextView) res_view.findViewById( R.id.evalResult);
        evalInput =  (EditText) res_view.findViewById( R.id.evalInput);
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
                MyUtils.hideSoftKeyBoard( v, (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE) );
            }
        });
        return res_view;
    }
}

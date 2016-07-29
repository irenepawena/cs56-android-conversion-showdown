package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.lang.reflect.AccessibleObject;

/**
 * Created by UMARU on 7/15/2016.
 */
public class ExpressionCalculator {


    Evaluator evaluator = new Evaluator();
    /*
    @Override
    public void onCreate( Bundle savedInstance ){
        super.onCreate( savedInstance );


    }
    */
    public double eval_double( String exp) throws EvaluationException{
        return Double.parseDouble( evaluator.evaluate( exp ) );
    }

    public String eval(String exp) throws EvaluationException{
        return evaluator.evaluate( exp );
    }


}

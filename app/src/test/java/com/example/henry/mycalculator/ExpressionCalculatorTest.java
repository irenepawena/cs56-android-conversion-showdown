package com.example.henry.mycalculator;

import net.sourceforge.jeval.EvaluationException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by UMARU on 7/15/2016.
 */
public class ExpressionCalculatorTest {
    ExpressionCalculator a;
    @Before
    public void setUp() throws Exception{
        a  =  new ExpressionCalculator();
    }

    @Test
    public void eval_double_test1(){
        double ans = 1;
        try {
            double res = a.eval_double("1");
            assertEquals(ans, res, 0.001);
        }
        catch( EvaluationException e){
            assert(false);
        }
    }

    @Test
    public void eval_double_test2(){
        double ans = 2;
        try {
            double res = a.eval_double("1 + 1 ");
            assertEquals(ans, res, 0.001);
        }
        catch( EvaluationException e){
            assert(false);
        }
    }

    @Test
    public void eval_double_test3(){
        double ans = 4;
        try {
            double res = a.eval_double("(1 + 1) * 2 ");
            assertEquals(ans, res, 0.001);
        }
        catch( EvaluationException e){
            assert(false);
        }
    }
}

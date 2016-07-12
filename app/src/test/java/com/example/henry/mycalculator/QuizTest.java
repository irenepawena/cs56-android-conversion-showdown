package com.example.henry.mycalculator;
import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by UMARU on 7/12/2016.
 */

public class QuizTest {
    @Test
    public void sanity_check_hex_1(){
        String hex_s = "NEWFNHEOL23KWM1DJO";
        boolean res = Quiz.sanity_check( hex_s, 16);
        boolean ans = false;
        assertEquals(ans, res);
    }

    @Test
    public void sanity_check_hex_2(){
        String hex_s = "12ABCDE";
        boolean res = Quiz.sanity_check( hex_s, 16);
        boolean ans = true;
        assertEquals(ans, res);
    }

    @Test
    public void sanity_check_bin_1(){
        String bin_s = "1231231aAASAD";
        boolean res = Quiz.sanity_check( bin_s , 2 );
        boolean ans = false;
        assertEquals(ans, res);
    }
    @Test
    public void sanity_check_bin_2(){
        String bin_s = "100101101110";
        boolean res = Quiz.sanity_check( bin_s , 2 );
        boolean ans = true;
        assertEquals(ans, res);
    }
}

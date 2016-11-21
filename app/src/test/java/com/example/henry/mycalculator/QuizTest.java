package com.example.henry.mycalculator;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by UMARU on 7/12/2016.
 */

public class QuizTest {
    @Test
    public void sanity_check_hex_1() {
        String hex_s = "NEWFNHEOL23KWM1DJO";
        try {
            boolean res = MyUtils.sanity_check(hex_s, 16);
            boolean ans = false;
            assertEquals(ans, res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_hex_2() {
        try {
            String hex_s = "12ABCDE";
            boolean res = MyUtils.sanity_check(hex_s, 16);
            boolean ans = true;
            assertEquals(ans, res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_bin_1() {
        try {
            String bin_s = "1231231aAASAD";
            boolean res = MyUtils.sanity_check(bin_s, 2);
            boolean ans = false;
            assertEquals(ans, res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_bin_2() {
        try {
            String bin_s = "100101101110";
            boolean res = MyUtils.sanity_check(bin_s, 2);
            boolean ans = true;
            assertEquals(ans, res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_dec_1() {
        try {
            String dec_s = "1abcg546";
            boolean res = MyUtils.sanity_check(dec_s,10);
            boolean ans = false;
            assertEquals(ans,res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_dec_2() {
        try {
            String dec_s = "1234";
            boolean res = MyUtils.sanity_check(dec_s,10);
            boolean ans = true;
            assertEquals(ans,res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_oct_1() {
        try {
            String oct_s = "16ah";
            boolean res = MyUtils.sanity_check(oct_s,10);
            boolean ans = false;
            assertEquals(ans,res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }

    @Test
    public void sanity_check_oct_2() {
        try {
            String oct_s = "140";
            boolean res = MyUtils.sanity_check(oct_s,10);
            boolean ans = true;
            assertEquals(ans,res);
        } catch (IntOverFlow e) {
            assert false;
        }
    }
}

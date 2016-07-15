package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by UMARU on 7/15/2016.
 */
public class MyUtils {
    public static  void hideSoftKeyBoard(View view, InputMethodManager imm){
        if ( view != null ) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void startNoHistoryAcitivity(Activity acc, Intent intent){
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        acc.startActivity( intent );
    }
}

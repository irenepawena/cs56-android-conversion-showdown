package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by UMARU on 7/26/2016.
 */
public class TestActivity2 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Integer> a = getIntent().getIntegerArrayListExtra("a");
        if(a==null){
            Log.i("a","isnull");
            return;
        }
        for(int i = 0 ; i < a.size() ; i++){
            Log.i("a",""+a.get(i));
        }
    }
}

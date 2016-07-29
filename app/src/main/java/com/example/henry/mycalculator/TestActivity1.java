package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by UMARU on 7/26/2016.
 */
public class TestActivity1 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, TestActivity2.class);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(10);
        intent.putExtra("a",a);
        MyUtils.startNoHistoryAcitivity(this, intent );

    }
}

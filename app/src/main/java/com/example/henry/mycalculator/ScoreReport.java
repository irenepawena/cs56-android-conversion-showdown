package com.example.henry.mycalculator;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class ScoreReport extends Activity {

    float result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_report);
        result = getIntent().getFloatExtra("result",0);
        TextView resultS = (TextView) findViewById(R.id.percentC);
        resultS.setText(String.valueOf(result + "%"));
    }



}

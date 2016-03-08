package com.example.henry.mycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreReport extends Activity {

    float result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_report);
        RelativeLayout lLayout = (RelativeLayout) findViewById(R.id.scorereport);
        result = getIntent().getFloatExtra("result",0);
        TextView resultS = (TextView) findViewById(R.id.percentC);
        resultS.setText(String.valueOf(result + "%"));

        if (result > 90){
            lLayout.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        if (result < 89 && result > 75){
            lLayout.setBackgroundColor(Color.parseColor("#FFA500"));
        }
        if (result < 74 && result > 55){
            lLayout.setBackgroundColor(Color.parseColor("#DC143C"));
        }
        if (result < 54){
            lLayout.setBackgroundColor(Color.parseColor("#FF0000"));
        }
    }

    public void newTestSelection(View view){
        Intent activity = new Intent(this, QuizSelection.class);
        startActivity(activity);
    }

    public void goToCalculator(View view){
        Intent activity = new Intent(this, Calculator.class);
        startActivity(activity);
    }


}

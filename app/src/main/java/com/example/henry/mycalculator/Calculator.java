package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Calculator extends Activity implements OnClickListener {

        Button btnStartAnotherActivity;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.calculator);

            btnStartAnotherActivity = (Button) findViewById(R.id.btnStartAnotherActivity);

            btnStartAnotherActivity.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(this, QuizSelection.class);

            // calling an activity using <intent-filter> action name

            startActivity(intent);
        }

        public void onButtonClick(View v){
            // 2 text fields - Edit Text
            EditText a1 = (EditText)findViewById(R.id.TFnum1);
            EditText a2 = (EditText)findViewById(R.id.TFnum2);

            // 1 result label - Text View
            TextView tv = (TextView)findViewById(R.id.Lresult);

            double num1, num2, ans;
            boolean flag = false; // no division by zero error

            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());
            ans = 0;

            if(v.getId() == R.id.Badd)
                ans = num1 + num2;
            if(v.getId() == R.id.Bsub)
                ans = num1 - num2;
            if(v.getId() == R.id.Bmult)
                ans = num1 * num2;
            if(v.getId() == R.id.Bdiv)
                // divison by 0 error
                if (num2 == 0)
                    flag = true; // division by zero error
                else
                    ans = num1 / num2;

            tv.setText(ans + "");
        }
}


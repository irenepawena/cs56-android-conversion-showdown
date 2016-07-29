package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Welcome extends Activity implements OnClickListener{

    Button btnStartAnotherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        btnStartAnotherActivity = (Button) findViewById(R.id.btnStartAnotherActivity);
        btnStartAnotherActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Introduction.class);
       startActivity( intent );
    }

}

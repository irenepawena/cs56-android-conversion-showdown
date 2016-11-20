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
import android.widget.EditText;
//Welcome screen with ENTER button
public class Welcome extends Activity implements OnClickListener{
    //ENTER button allows user to continue to the Introduction page
    Button ENTERbttn;
    public final static String EXTRA_NAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        ENTERbttn = (Button) findViewById(R.id.ENTERbttn);
        ENTERbttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText nameUser = (EditText) findViewById(R.id.user_name); //Define widget and set to variable
        String name = nameUser.getText().toString(); //Set value of field to 'name' variable
        Intent intent = new Intent(this, Introduction.class);
        intent.putExtra(EXTRA_NAME, name); //Pass name of user to next activity
       startActivity( intent );
    }

}

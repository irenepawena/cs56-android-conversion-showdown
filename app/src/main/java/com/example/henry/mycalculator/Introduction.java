package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class Introduction extends Activity implements OnClickListener {

    Button btnStartAnotherActivity;

    public void hideSoftKeyBoard(View view){
        if ( view != null ) {
            InputMethodManager imm = (InputMethodManager) getSystemService(android.content.Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);

        Button b = (Button)this.findViewById(R.id.click_btn);
        Button startQuizButton = (Button) findViewById( R.id.startQuizButton);
        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView resp = (TextView) findViewById(R.id.response);
                EditText name = (EditText) findViewById(R.id.user_name);
                String str = "Welcome " + name.getText().toString() + " !";
                resp.setText(str);
                MyUtils.hideSoftKeyBoard( v, (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE) );
            }
        });

        startQuizButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizSelection.class);
                MyUtils.startNoHistoryAcitivity( getActivity(), intent );
            }

        });

        btnStartAnotherActivity = (Button) findViewById(R.id.btnStartAnotherActivity);

        btnStartAnotherActivity.setOnClickListener(this);
    }

    public Activity getActivity(){
        return this;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, ExpressionActivity.class);
        MyUtils.startNoHistoryAcitivity( this, intent );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

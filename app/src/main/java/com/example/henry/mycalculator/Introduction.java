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

        Button startQuizButton = (Button) findViewById( R.id.startQuizButton);
        Button startConverterButton = (Button) findViewById( R.id.startConverterButton );

        TextView resp = (TextView) findViewById(R.id.response);
        Intent intent = getIntent();
        String name = intent.getStringExtra(Welcome.EXTRA_NAME);
        String str = "Welcome " + name + "!";
        resp.setText(str);


        startQuizButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizSelection.class);
                MyUtils.startNoHistoryAcitivity( getActivity(), intent );
            }

        });

        startConverterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConverterActivity.class);
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

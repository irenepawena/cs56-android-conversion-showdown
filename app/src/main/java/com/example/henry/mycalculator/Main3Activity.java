package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main3Activity extends Activity implements OnClickListener {

   /* Button btnStartAnotherActivity2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnStartAnotherActivity2 = (Button) findViewById(R.id.btnStartAnotherActivity);

        btnStartAnotherActivity2.setOnClickListener(this);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);

        // Calling another activity Main4Activitytest start the quiz

        startActivity(intent);
    }

}
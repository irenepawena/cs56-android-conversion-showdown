package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class Main4Activityquiz extends Activity implements OnClickListener {


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main4Activityquiz.class);

        // Calling another activity Main4Activitytest start the quiz

        startActivity(intent);
    }


}

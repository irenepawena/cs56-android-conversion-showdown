package com.example.henry.mycalculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Main3Activity extends Activity implements OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View view) {
        Intent intentextra = new Intent(this, Main3Activity.class);
        intentextra.putStringArrayListExtra("selection",selection);
        // Calling another activity Main4Activitytest start the quiz

        startActivity(intentextra);
    }

    public void ButtonStartQuiz(View v) {
        if (v.getId() == R.id.btnStartQuizActivity) {
            Intent i = new Intent(Main3Activity.this, Main4Activityquiz.class);
            startActivity(i);
        }
    }

    ArrayList<String> selection = new ArrayList<String>();

    public void selectItem(View view){
        boolean checked = ((CheckBox)view).isChecked();
            switch(view.getId()){
                case R.id.Decimal_Binary:
                    if(checked){
                        selection.add("Decimal_Binary");
                    } else {
                        selection.remove("Decimal_Binary");
                    }
                    break;

                case R.id.Decimal_Octal:
                    if(checked){
                        selection.add("Decimal_Octal");
                    } else {
                        selection.remove("Decimal_Octal");
                    }
                    break;

                case R.id.Binary_Octal:
                    if(checked){
                        selection.add("Binary_Octal");
                    } else {
                        selection.remove("Binary_Octal");
                    }
                    break;

                case R.id.Decimal_Hexadecimal:
                    if(checked){
                        selection.add("Decimal_Hexadecimal");
                    } else {
                        selection.remove("Decimal_Hexadecimal");
                    }
                    break;

                case R.id.Binary_Hexadecimal:
                    if(checked){
                        selection.add("Binary_Hexadecimal");
                    } else {
                        selection.remove("Binary_Hexadecimal");
                    }
                    break;

                case R.id.Octal_Hexadecimal:
                    if(checked){
                        selection.add("Octal_Hexadecimal");
                    } else {
                        selection.remove("Octal_Hexadecimal");
                    }
                    break;
            }
    }

    public void Qnum(View view) {
        // is the button checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Which radio button clicked?
        switch (view.getId()) {
            case R.id.SixQs:
                if (checked)
                    // 6 questions
                    break;
            case R.id.TwelveQs:
                if(checked)
                    // 12 questions
                break;
            case R.id.twenty4Qs:
                if(checked)
                    // 24 questions
                break;
            case R.id.Endless:
                if(checked)
                    // Endless
                break;
        }

    }

   /* @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main3 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.henry.mycalculator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main3 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.henry.mycalculator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
*/
}
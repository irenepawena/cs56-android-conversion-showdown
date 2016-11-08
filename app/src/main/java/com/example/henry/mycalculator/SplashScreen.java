package com.example.henry.mycalculator;

import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.view.animation.Animation;

public class SplashScreen extends Activity {
    /** Duration of the Splash Screen display **/
    private final int SPLASH_TIME = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
                    public void run() {
                    Intent mainIntent = new Intent(SplashScreen.this,Introduction.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
            }
        }, SPLASH_TIME);
        //Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_screen);

    }
}

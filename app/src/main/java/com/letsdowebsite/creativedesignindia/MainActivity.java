package com.letsdowebsite.creativedesignindia;

import android.app.Activity;
import android.content.Intent;

import android.os.Handler;

import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int secondsDelayed = 1;
        new Handler().postDelayed( new Runnable() {
            public void run() {
                startActivity(new Intent(MainActivity.this, Splash.class));

                finish();

            }
        }, secondsDelayed * 3000);
    }

}
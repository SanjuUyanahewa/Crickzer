package com.crickzer.app.crickzer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class LoadScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_load_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeintent=  new Intent (LoadScreen.this,MainScreen.class);

                startActivity(homeintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}


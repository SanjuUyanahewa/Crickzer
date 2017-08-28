package com.crickzer.app.crickzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class LoginScreen extends AppCompatActivity {
    ImageButton btnBackToLive1;
    ImageButton btnreatAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBackToLive1 = (ImageButton) findViewById(R.id.backToLive1);

        btnBackToLive1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(LoginScreen.this, ThirdScreen.class);
                startActivity(intentLoadNewActivity);
            }
        });

        btnreatAcc = (ImageButton) findViewById(R.id.creatAcc);

        btnreatAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(LoginScreen.this, RegScreen.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}

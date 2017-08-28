package com.crickzer.app.crickzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class RegScreen extends AppCompatActivity {
    ImageButton btnBackToLive2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBackToLive2 = (ImageButton) findViewById(R.id.backToLive2);

        btnBackToLive2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(RegScreen.this, LoginScreen.class);
                startActivity(intentLoadNewActivity);
            }
        });


    }
}

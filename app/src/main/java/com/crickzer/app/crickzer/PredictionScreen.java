package com.crickzer.app.crickzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PredictionScreen extends AppCompatActivity {

    ImageButton btnBackToLive3;

    ArrayList<String> catergory = new ArrayList<String>();
    String[][] oneOver = new String[50][6];
    Random rand = new Random();

    ImageButton refreshOvers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBackToLive3 = (ImageButton) findViewById(R.id.backToLive3);

        btnBackToLive3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(PredictionScreen.this, ThirdScreen.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Button confirmOvers = (Button) findViewById(R.id.confirmOvers);

        refreshOvers = (ImageButton) findViewById(R.id.imageButton10);

        refreshOvers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrediction();
                getPredictions(oneOver);


            }
        });


    }

    public String[][] setPrediction() {

//add more  items you want to predict
        catergory.add("1");
        catergory.add("2");
        catergory.add("3");
        catergory.add("4");
        catergory.add("5");
        catergory.add("6");
        catergory.add("W");
        catergory.add("NB");
        catergory.add("Wht");
        catergory.add("1RW");
        //Then count items in arraylist and put that number instead of 10 in 55 line

        for (int k = 0; k < 50; k++) {
            for (int i = 0; i < 6; i++) {
                int getPredictNum = rand.nextInt(10) + 0;
                oneOver[k][i] = catergory.get(getPredictNum);
            }
        }

        return oneOver;

    }

    public void getPredictions(String[][] oneOver) {
        //TextView displayOvers = (TextView)findViewById(R.id.displayOvers);

        TextView TextVew1 = (TextView) findViewById(R.id.txt11);
        TextView TextVew2 = (TextView) findViewById(R.id.txt12);
        TextView TextVew3 = (TextView) findViewById(R.id.txt13);
        TextView TextVew4 = (TextView) findViewById(R.id.txt14);
        TextView TextVew5 = (TextView) findViewById(R.id.txt15);
        TextView TextVew6 = (TextView) findViewById(R.id.txt16);
        TextView TextVew7 = (TextView) findViewById(R.id.txt21);
        TextView TextVew8 = (TextView) findViewById(R.id.txt22);
        TextView TextVew9 = (TextView) findViewById(R.id.txt23);
        TextView TextVew10 = (TextView) findViewById(R.id.txt24);
        TextView TextVew11 = (TextView) findViewById(R.id.txt25);
        TextView TextVew12 = (TextView) findViewById(R.id.txt26);
        TextView TextVew13 = (TextView) findViewById(R.id.txt31);
        TextView TextVew14 = (TextView) findViewById(R.id.txt32);
        TextView TextVew15 = (TextView) findViewById(R.id.txt33);
        TextView TextVew16 = (TextView) findViewById(R.id.txt34);
        TextView TextVew17 = (TextView) findViewById(R.id.txt35);
        TextView TextVew18 = (TextView) findViewById(R.id.txt36);
        TextView TextVew19 = (TextView) findViewById(R.id.txt41);
        TextView TextVew20 = (TextView) findViewById(R.id.txt42);
        TextView TextVew21 = (TextView) findViewById(R.id.txt43);
        TextView TextVew22 = (TextView) findViewById(R.id.txt44);
        TextView TextVew23 = (TextView) findViewById(R.id.txt45);
        TextView TextVew24 = (TextView) findViewById(R.id.txt46);

        //displayOvers.setText("");
       /* for(int x=0;x<4;x++){

            int r=rand.nextInt(50)+0;

            for(int y=0;y<6;y++){

                displayOvers.append(oneOver[r][y]);
                //displayOvers.append(" ");


            }
           // displayOvers.append("\n\n");



        }*/
        int r = rand.nextInt(50) + 0;
        TextVew1.setText("");
        TextVew1.append(oneOver[r][0]);
        TextVew2.setText("");
        TextVew2.append(oneOver[r][1]);
        TextVew3.setText("");
        TextVew3.append(oneOver[r][2]);
        TextVew4.setText("");
        TextVew4.append(oneOver[r][3]);
        TextVew5.setText("");
        TextVew5.append(oneOver[r][4]);
        TextVew6.setText("");
        TextVew6.append(oneOver[r][5]);

        r = rand.nextInt(50) + 0;
        TextVew7.setText("");
        TextVew7.append(oneOver[r][0]);
        TextVew8.setText("");
        TextVew8.append(oneOver[r][1]);
        TextVew9.setText("");
        TextVew9.append(oneOver[r][2]);
        TextVew10.setText("");
        TextVew10.append(oneOver[r][3]);
        TextVew11.setText("");
        TextVew11.append(oneOver[r][4]);
        TextVew12.setText("");
        TextVew12.append(oneOver[r][5]);

        r = rand.nextInt(50) + 0;
        TextVew13.setText("");
        TextVew13.append(oneOver[r][0]);
        TextVew14.setText("");
        TextVew14.append(oneOver[r][1]);
        TextVew15.setText("");
        TextVew15.append(oneOver[r][2]);
        TextVew16.setText("");
        TextVew16.append(oneOver[r][3]);
        TextVew17.setText("");
        TextVew17.append(oneOver[r][4]);
        TextVew18.setText("");
        TextVew18.append(oneOver[r][5]);

        r = rand.nextInt(50) + 0;
        TextVew19.setText("");
        TextVew19.append(oneOver[r][0]);
        TextVew20.setText("");
        TextVew20.append(oneOver[r][1]);
        TextVew21.setText("");
        TextVew21.append(oneOver[r][2]);
        TextVew22.setText("");
        TextVew22.append(oneOver[r][3]);
        TextVew23.setText("");
        TextVew23.append(oneOver[r][4]);
        TextVew24.setText("");
        TextVew24.append(oneOver[r][5]);


    }


}
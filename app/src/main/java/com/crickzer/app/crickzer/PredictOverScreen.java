package com.crickzer.app.crickzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PredictOverScreen extends AppCompatActivity {

    ArrayList<String> catergory=new ArrayList<String>();
    String[][] oneOver=new String[50][6];
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_over_screen);
        Button refreshOvers=(Button)findViewById(R.id.refreshOvers);
        Button confirmOvers=(Button)findViewById(R.id.confirmOvers);

        refreshOvers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrediction();
                getPredictions(oneOver);


            }
        });

    }


    public String[][] setPrediction(){

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

        for(int k=0;k<50;k++){
            for(int i=0;i<6;i++){
                int getPredictNum = rand.nextInt(10) + 0;
                oneOver[k][i]=catergory.get(getPredictNum);
            }
        }

        return oneOver;

    }

    public void getPredictions(String[][] oneOver){
        TextView displayOvers = (TextView)findViewById(R.id.displayOvers);
        displayOvers.setText("");
        for(int x=0;x<4;x++){

            int r=rand.nextInt(50)+0;

            for(int y=0;y<6;y++){

                displayOvers.append(oneOver[r][y]);
                displayOvers.append(" ");


            }
            displayOvers.append("\n\n");



        }



    }



}

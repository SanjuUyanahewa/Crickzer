package com.crickzer.app.crickzer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

import static com.crickzer.app.crickzer.R.id.listView1;

public class MainScreen extends AppCompatActivity {
    private static final String TAG = "MyActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final String[] myItems1={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};
        final String[] myItems2={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};
       ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout. list_layout,myItems1);
        ListView  listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout. list_layout,myItems2);
       ListView listView2=(ListView) findViewById(R.id.listView2);
       listView2.setAdapter(adapter2);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                for(int x=0;x<myItems1.length;x++){
                    if (position == x){

                        Intent myintent = new Intent(view.getContext(),ThirdScreen.class);
                        startActivityForResult(myintent,x);}
                    }
                }

        });




    }



}

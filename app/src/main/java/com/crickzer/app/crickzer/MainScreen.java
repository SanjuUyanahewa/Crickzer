package com.crickzer.app.crickzer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String[] myItems1={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};
        String[] myItems2={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout. list_layout,myItems1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout. list_layout,myItems2);
        ListView listView1=(ListView) findViewById(R.id.listView1);
        ListView listView2=(ListView) findViewById(R.id.listView2);
        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                if (position==0){
                    Intent myintent = new Intent(view.getContext(),ThirdScreen.class);
                    startActivityForResult(myintent,0);}
            }
        });
    }
}

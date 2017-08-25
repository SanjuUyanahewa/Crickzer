package com.crickzer.app.crickzer;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class MainScreen extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    static HashMap<Integer, String> matchList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new JasonMatches().execute("http://cricapi.com/api/matches/XlPvSB9ReQgIquCbxhaPUDs2NLL2");

        //final String[] myItems1={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};
        String[] myItems2={"Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand","Sri Lanka Vs India","Sri Lanka Vs New Zealand","Pakistan Vs New Zealand","Sri Lanka Vs South Africa","Australia Vs New Zealand"};

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout. list_layout,myItems2);
        ListView listView2=(ListView) findViewById(R.id.listView2);
        listView2.setAdapter(adapter2);

        Intent scoreIntent = new Intent(MainScreen.this,ThirdScreen.class);
        startActivity(scoreIntent);

    }

    public class JasonMatches extends AsyncTask<String,String,String> {


        ArrayList countries = new ArrayList<String>(){{
            add("Afghanistan");
            add("Australia");
            add("Bangladesh");
            add("England");
            add("India");
            add("Ireland");
            add("New Zealand");
            add("Pakistan");
            add("South Africa");
            add("Sri Lanka");
            add("West Indies");
            add("Zimbabwe");
        }};

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url=new URL(params[0]);
                connection=(HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream stream=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();
                String line="";

                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }
                String cricJason=buffer.toString();
                JSONObject parentJason=new JSONObject(cricJason);
                JSONArray arrayJasonCrick=parentJason.getJSONArray("matches");
                StringBuffer jasonBuffer=new StringBuffer();

                for(int i=0;i<arrayJasonCrick.length();i++){

                    JSONObject getJasonData=arrayJasonCrick.getJSONObject(i);
                    int matchID=getJasonData.getInt("unique_id");
                    String firstTeam=getJasonData.getString("team-1");
                    String secondTeam=getJasonData.getString("team-2");
                    String date=getJasonData.getString("date");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar cal = Calendar.getInstance();
                    String currentDate = dateFormat.format(cal.getTime()).toString();

                    if(countries.contains(firstTeam) && countries.contains(secondTeam) && date.contains("2017-08-28")){
                        matchList.put(matchID,firstTeam + " Vs " + secondTeam);
                    };
                }

                return jasonBuffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null)
                    connection.disconnect();
                try {
                    if(reader !=null)
                        reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Arrays.copyOf(matchList.values().toArray(), matchList.values().toArray().length, String[].class));
            ListView  listView1 = (ListView) findViewById(R.id.listView1);
            listView1.setAdapter(adapter1);
            adapter1.notifyDataSetChanged();

            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                    Intent scoreIntent = new Intent(MainScreen.this,ThirdScreen.class);
                    ArrayList<Integer> matchKeys = new ArrayList<>();
                    for (Integer key : matchList.keySet())
                        matchKeys.add(key);
                    scoreIntent.putExtra("matchID",matchKeys.get(position));
                    startActivity(scoreIntent);
                }

            });
        }
    }
}

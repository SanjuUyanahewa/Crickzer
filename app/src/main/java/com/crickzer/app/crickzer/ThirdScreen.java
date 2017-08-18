package com.crickzer.app.crickzer;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

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

public class ThirdScreen extends AppCompatActivity {

    private TextView txtResponseList;
     int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_third_screen);
        Button btnHitData=(Button)findViewById(R.id.hitData);
        Button btnFirstTeam=(Button)findViewById(R.id.btnFirstTeam);
       Button btnPredict=(Button)findViewById(R.id.btnPredict);

        txtResponseList = (TextView)findViewById(R.id.responseList);
        //live matches button click event
        btnHitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //url of the api-Matches

                new JasonMatches().execute("http://cricapi.com/api/matches/XlPvSB9ReQgIquCbxhaPUDs2NLL2");

                }
        });
        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //url of the api-scores
                Intent predictIntent = new Intent(ThirdScreen.this,PredictOverScreen.class);
                startActivity(predictIntent);
            }
        });

        //live score button click event
        btnFirstTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //url of the api-scores
                new JasonScores().execute("http://cricapi.com/api/cricket/?apikey=XlPvSB9ReQgIquCbxhaPUDs2NLL2");

            }
        });

    }

//matches jason file
    public class JasonMatches extends AsyncTask<String,String,String>{


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
                    int teamID=getJasonData.getInt("unique_id");
                    String firstTeam=getJasonData.getString("team-1");
                    String secondTeam=getJasonData.getString("team-2");
                    jasonBuffer.append("id :"+teamID+"\n"+"Team 1 :"+firstTeam+"\n"+"Team 2 :"+secondTeam+"\n\n");
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
            txtResponseList.setText(result);

        }
    }
//live score jason file
    public class JasonScores extends AsyncTask<String,String,String>{


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
                JSONArray arrayJasonCrick=parentJason.getJSONArray("data");
                StringBuffer jasonBuffer=new StringBuffer();

                for(int i=0;i<arrayJasonCrick.length();i++){

                    JSONObject getJasonData=arrayJasonCrick.getJSONObject(i);
                   // int teamID=getJasonData.getInt("unique_id");
                    String description=getJasonData.getString("description");
                    jasonBuffer.append("Description"+description+"\n\n");
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
            //result set to textView
            txtResponseList.setText(result);

        }
    }
}

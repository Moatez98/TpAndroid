package com.example.e_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListNews extends AppCompatActivity {
ListView lstNews ;
public static List <News> valeurs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        lstNews=findViewById(R.id.lst_news);
        new ChargeurListe().execute();
    }
   private class ChargeurListe extends AsyncTask<Void,Void,String>{

       @Override
       protected String doInBackground(Void... voids) {
           try {
           URL adresse=new URL (UtilsConst.prefixUrl+"get_all_news.php");
           HttpURLConnection cnx =(HttpURLConnection) adresse.openConnection();

               cnx.setRequestMethod("GET");

           cnx.setDoOutput(true);

           BufferedReader read= new BufferedReader (new InputStreamReader(cnx.getInputStream()));
           String ligne ;
           StringBuilder str = new StringBuilder();
               while((ligne =read.readLine())!=null)
               {
                   str.append(ligne);
               }
               return str.toString();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return "";
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);
           valeurs = new ArrayList<>();
           try {
               JSONArray tab= new JSONArray(s);
               for(int i=0;i<tab.length();i++)
               {
                   JSONObject ob = (JSONObject) tab.get(i);
                   valeurs.add(NewsFactory.creatNews(ob));

               }

               ArrayAdapter ad = new ArrayAdapter(ListNews.this,android.R.layout.simple_list_item_1,valeurs);

               lstNews.setAdapter(ad);

               lstNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       Bundle b=new Bundle();
                       b.putInt("p",position);
                       Intent it=new Intent(ListNews.this,DetailActivity.class);
                       it.putExtras(b);
                       startActivity(it);

                   }
               });


           } catch (JSONException e) {
               e.printStackTrace();
           }


       }
   }



}
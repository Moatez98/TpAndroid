package com.example.e_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ListNews extends AppCompatActivity {
ListView lstNews ;
public static News[] valeurs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        lstNews=findViewById(R.id.lst_news);
        chargerNews();

     // ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,valeurs);

        //lstNews.setAdapter(ad);

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
   }


    private void chargerNews() {
        valeurs=new News [3];
        valeurs[0]=new News(1000, LocalTime.now(), LocalDate.now(),"sport","Match","FCB-RM");
        valeurs[1]=new News(3000, LocalTime.of(12,05), LocalDate.of(2021,03,05),"sport","Cours","Formula 1");
        valeurs[2]=new News(4000, LocalTime.of(10,30), LocalDate.of(2021,03,06),"culture","theatre","inauguration");

    }
}
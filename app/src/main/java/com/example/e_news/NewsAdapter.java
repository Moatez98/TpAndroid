package com.example.e_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.e_news.ListNews.valeurs;

public class NewsAdapter extends BaseAdapter {
 List<News>liste;
 Context ctx;
 public NewsAdapter (List<News> liste,Context ctx){
     this.liste= liste ;
     this.ctx=ctx;
 }



    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int position) {
        return liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return liste.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     if(convertView==null){
         LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView=inflater.inflate(R.layout.news_item,null);
         News ns = valeurs.get(position);
         TextView txtdate=convertView.findViewById(R.id.txt_Date);
         TextView txtTitre=convertView.findViewById(R.id.txt_titre);;
         ImageView imgCategorie=convertView.findViewById(R.id.imageView);
         txtdate.setText(ns.getDatePublication()+"à"+ns.getTempsPublication());
         txtTitre.setText(ns.getTitre());
         String cat =ns.getCategorie().toLowerCase();
            switch (cat){
                case "sport":;break;
                case "culture":;break;
                case "politique":;break;

            }


     }
        return convertView;
    }
}

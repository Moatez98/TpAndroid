package com.example.e_news;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewsFactory {
    public static News creatNews(JSONObject ob) throws JSONException {
        long id =ob.getLong("id");
        LocalTime tempsPublication=LocalTime.parse(ob.getString("tempsPublication"));
        LocalDate datePublication=LocalDate.parse(ob.getString("datePublication"));
        String titre=ob.getString("titre");
        String categorie=ob.getString("categorie");
        String contenu=ob.getString("contenu");
        return new News(id,tempsPublication,datePublication,categorie,titre,contenu);


    }
}

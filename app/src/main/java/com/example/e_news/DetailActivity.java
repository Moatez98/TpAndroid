package com.example.e_news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.e_news.ListNews.valeurs;

public class DetailActivity extends AppCompatActivity {
    TextView txtTitle;
    TextView txtDate;
    TextView txtTemps;
    TextView txtCategorie;
    TextView txtContenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtTitle =findViewById(R.id.lbl_titre);
        txtTemps =findViewById(R.id.lbl_temps);
        txtDate =findViewById(R.id.lbl_date);
        txtCategorie =findViewById(R.id.lbl_categorie);
        txtContenu =findViewById(R.id.lbl_contenu);
        int p=getIntent().getIntExtra("p",-1);
        News n;
        n = valeurs.get(p);
        txtTitle.setText(n.getTitre());
        txtContenu.setText(n.getContenu());
        txtCategorie.setText(n.getCategorie());
        txtDate.setText(n.getDatePublication().toString());
        txtTemps.setText(n.getTempsPublication().toString());
    }
}
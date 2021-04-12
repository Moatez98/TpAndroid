package com.example.e_news;

import java.nio.channels.ClosedChannelException;
import java.time.LocalDate;
import java.time.LocalTime;

public class News {


    private  long id ;
    private LocalTime tempsPublication;
    private LocalDate datePublication;
    private String categorie;
    private String titre ;
    private String contenu;

    @Override
    public String toString() {
        return datePublication+"--"+titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTempsPublication() {
        return tempsPublication;
    }

    public void setTempsPublication(LocalTime tempsPublication) {
        this.tempsPublication = tempsPublication;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public News() {
    }
    public News(long id , LocalTime tempsPublication,LocalDate datePublication,String categorie,String titre ,String contenu) {
        this.id=id;
        this.tempsPublication=tempsPublication;
        this.datePublication=datePublication;
        this.categorie=categorie;
        this.titre=titre;
        this.contenu=contenu;
    }

}

package com.example.e_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Button btConnecter;
    Button btQuitter;
    EditText txtLogin ;
    EditText txtPassword ;
    int nbEssaisRestant=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//ya3mel relation maa lparti design
       //lier les composants au desgin
        btConnecter =findViewById(R.id.bt_connecter);
        btQuitter =findViewById(R.id.bt_quitter);
        txtLogin = findViewById(R.id.txt_login);
        txtPassword = findViewById(R.id.txt_password);
        //Listeners
        btQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (nbEssaisRestant==0){
                 //   System.exit( 0);
                //}
                String login=txtLogin.getText().toString();
                String passowrd =txtPassword.getText().toString();
                new LoginTesteur().execute(login,passowrd);

            }
        });
    }

private class LoginTesteur extends AsyncTask<String,Void,String>{
        protected String doInBackground(String...strings){
            try {
                URL adresse=new URL ("http://192.168.1.3/cnx.php");
                HttpURLConnection cnx =(HttpURLConnection) adresse.openConnection();
                cnx.setRequestMethod("POST");
                cnx.setDoOutput(true);
                DataOutputStream out =new DataOutputStream((cnx.getOutputStream()));
                String email =strings[0];
                String password=strings[1];
                String params="email="+email+"&password="+password;
                out.writeBytes(params);
                out.flush();
                out.close();
                BufferedReader read= new BufferedReader (new InputStreamReader(cnx.getInputStream()));
                String ligne ;
                StringBuilder str = new StringBuilder();
                while((ligne =read.readLine())!=null)
                {
                    str.append(ligne.trim());
                }
                System.out.print(str.toString());
                return str.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "";
        }
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            if (s.equals("1")){
                //ouvrire liste news
                Intent fenetre = new Intent (  MainActivity.this,ListNews.class);
                startActivity(fenetre);

            }else{
                //affichage message d erreur
                Toast.makeText(MainActivity.this, R.string.error_login, Toast.LENGTH_LONG).show();
                txtPassword.setText("");
                txtLogin.setText("");
                nbEssaisRestant-- ;
            }
        }

}
}
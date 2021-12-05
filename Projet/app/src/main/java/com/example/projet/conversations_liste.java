package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class conversations_liste extends AppCompatActivity {

  TextView textview;
  Button b20;
  EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversations_liste);

      input = findViewById(R.id.text);
      textview = (TextView)findViewById(R.id.text);

      // Demarrage du thread pour actualiser les messages
      get();

    };


    // Thread qui s'actualise toutes les secondes pour mettre à jour la liste des messages
  public void get() {
      Thread background = new Thread(new Runnable() {
        public void run() {

          boolean var;
          while (var = true){
            try {
              Thread.sleep(1000);
              Log.e("BIS", "BIS");
              httpCall("http://192.168.1.136/Chat_Android/getmessage.php");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      });
      new Thread(background).start();


  };


  public void httpCall(String url) {

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
      new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
          textview.setSingleLine(false);
          textview.setLines(99);
          textview.setText(response);
          Log.e(this.getClass().toString(), "Request successful!");
        }
      }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        textview.setText("Erreur");
        Log.e(this.getClass().toString(), "Erreur!");
      }
    });

    queue.add(stringRequest);

  }

  @Override
  public void onBackPressed() {
    Intent intent = new Intent(this, conversations.class);
    startActivity(intent);

  }
}


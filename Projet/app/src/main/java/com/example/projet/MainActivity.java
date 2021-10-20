package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    input = findViewById(R.id.text);
    textview = (TextView) findViewById(R.id.text);

    // ***************** Obtenir l'API, et l'afficher *****************

    b10 = (Button) findViewById(R.id.button10);

    b10.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        httpCall("http://10.60.21.217/projet_android/conn_bdd.php?pseudo=tata&mail=oiuaz&mdp=toto"); // Mettre son adresse IP

        Log.e("Thread tick.", "onClick");
      }
    });
  }

  public void httpCall(String url) {

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
      new Response.Listener<String>() {
        @Override
        public void onClick(View v) {
          openActivity1();
        }
      });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openActivity2();
            }
        });


    }

  public void openActivity1() { // Fonction qui permet d'aller à l'activité 1
    Intent intent = new Intent(this, identification.class);
    startActivity(intent);
  }

    public void openActivity2() { // Fonction qui permet d'aller à l'activité 2
        Intent intent2 = new Intent(this, inscription.class);
        startActivity(intent2);
    }
}

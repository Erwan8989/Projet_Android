package com.example.projet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class connexion_inscription extends Activity {

  String url ="https://api.github.com/zen";
  Button b10;
  TextView textview;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inscription);


    // ***************** Obtenir l'API, et l'afficher *****************
    textview = (TextView)findViewById(R.id.text);
    b10 = (Button) findViewById(R.id.button10);

    b10.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        httpCall("https://api.github.com/zen");

        Log.e("Thread tick.", "onClick");
      }
    });
  }

  public void httpCall(String url) {

    RequestQueue queue = Volley.newRequestQueue(this);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
      new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
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
}

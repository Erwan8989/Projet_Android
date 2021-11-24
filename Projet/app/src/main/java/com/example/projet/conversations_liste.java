package com.example.projet;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
      b20 = (Button) findViewById(R.id.button20);

      b20.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          httpCall("http://192.168.56.1/Chat_Android/getmessage.php");

          Log.e("Thread tick.", "onClick");
        }
      });
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
}

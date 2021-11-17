package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      b1 = (Button) findViewById(R.id.button1);
      b1.setOnClickListener(new View.OnClickListener() {
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


  public void openActivity1() {
    Intent identification = new Intent(this, identification.class);
    startActivity(identification);
      finish();
  }

    public void openActivity2() {
        Intent inscription = new Intent(this, inscription.class);
        startActivity(inscription);
        finish();
    }
}
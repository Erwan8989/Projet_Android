package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button b1, b2;

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


  public void openActivity1() { // Fonction qui permet d'aller à l'activité 1
    Intent intent = new Intent(this, identification.class);
    startActivity(intent);
  }

    public void openActivity2() { // Fonction qui permet d'aller à l'activité 2
        Intent intent2 = new Intent(this, inscription.class);
        startActivity(intent2);
    }
}

package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class conversations extends AppCompatActivity {

    Button b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversations);

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

        b5 = (Button) findViewById(R.id.button5);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity5();
                }
            });

    }

    public void openActivity4() {
        Intent parametres = new Intent(this, parametres.class);
        startActivity(parametres);
        finish();
    }

    public void openActivity5() {
        Intent conversations_liste = new Intent(this, conversations_liste.class);
        startActivity(conversations_liste);
        finish();
    }
}

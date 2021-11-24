package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class parametres extends AppCompatActivity {

    Button b6, b8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametres);

        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });

        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        }

    public void openActivity6() {
        Intent parametres_informations_personnelles = new Intent(this, parametres_informations_personnelles.class);
        startActivity(parametres_informations_personnelles);
        finish();
    }

    public void openActivity8() {
        Intent MainActivity = new Intent(this, MainActivity.class);
        startActivity(MainActivity);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, conversations.class);
        startActivity(intent);}
}

package com.example.projet;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class parametres_informations_personnelles extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametres_informations_personnelles);
    };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, parametres.class);
        startActivity(intent);}
}
package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet.R;

public class conversations_liste extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversations_liste);
    };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, conversations.class);
        startActivity(intent);

    }
}

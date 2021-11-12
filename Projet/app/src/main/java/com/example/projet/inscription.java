package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class inscription extends AppCompatActivity {

  android.widget.EditText Pseudo, AddressMail, mdp;
  Button b3;
  TextView titles;
  ProgressBar progressBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inscription);

    Pseudo = findViewById(R.id.InscriptionPseudo);
    AddressMail = findViewById(R.id.inscriptionAdresseMail);
    mdp = findViewById(R.id.MotDePasse);
    b3 = findViewById(R.id.button3);
    progressBar = findViewById(R.id.progress);
    titles = findViewById(R.id.signUp);

    titles.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), inscription.class);
        startActivity(intent);
        finish();
      }
    });


    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String pseudo, email, password;
        pseudo = String.valueOf(Pseudo.getText());
        email = String.valueOf(AddressMail.getText());
        password = String.valueOf(mdp.getText());

        // Verification of the type of the value entered in the EditText
        if (!pseudo.equals("") && !email.equals("") && !password.equals("")) {
          //Start ProgressBar first (Set visibility VISIBLE)
          progressBar.setVisibility(View.VISIBLE);
          Handler handler = new Handler(Looper.getMainLooper());
          handler.post(new Runnable() {
            @Override
            public void run() {
              //Starting Write and Read data with URL
              //Creating array for parameters
              String[] field = new String[3];
              field[0] = "pseudo";
              field[1] = "email";
              field[2] = "mdp";

              //Creating array for data
              String[] data = new String[3];
              data[0] = "pseudo";
              data[1] = "email";
              data[2] = "mdp";

              PutData putData = new PutData("http://192.168.1.136/Chat_Android/signup.php", "POST", field, data);
              if (putData.startPut()) {
                if (putData.onComplete()) {
                  progressBar.setVisibility(View.GONE);

                  String result = putData.getResult();

                  if (result.equals("Sign Up Success")) {
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    Intent identification = new Intent(getApplicationContext(), identification.class);
                    startActivity(identification);
                    finish();
                  } else {

                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                  }
                }
              }
            }
          });

        } else {
          Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }
}

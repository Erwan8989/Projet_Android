package com.example.projet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class inscription extends AppCompatActivity {

  TextInputEditText Pseudo, AdresseMail, mdp;
  Button b3;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inscription);

    Pseudo = findViewById(R.id.InscriptionPseudo);
    AdresseMail = findViewById(R.id.inscriptionAdresseMail);
    mdp = findViewById(R.id.MotDePasse);
    b3 = findViewById(R.id.button3);

    b3.setOnClickListener(new View.OnClickListener() {
      @override
      public void onClick (View v){

        String pseudo, email, password;
        pseudo = String.valueOf(Pseudo.getText());

        //Start ProgressBar first (Set visibility VISIBLE)
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
          @Override
          public void run() {
            //Starting Write and Read data with URL
            //Creating array for parameters
            String[] field = new String[3];
            field[0] = "pseudo";
            field[1] = "email";
            field[2] = "password";

            //Creating array for data
            String[] data = new String[2];
            data[0] = "data-1";
            data[1] = "data-2";
            PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
            if (putData.startPut()) {
              if (putData.onComplete()) {
                String result = putData.getResult();
                //End ProgressBar (Set visibility to GONE)
              }
            }
            //End Write and Read data with URL
          }
        });

      }
    });



      }
    });
  }
}

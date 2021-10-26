package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class inscription extends AppCompatActivity {

  Button _btnReg;
  EditText  _txtEmail, _txtUser, _txtPass;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inscription);

    _btnReg=(Button)findViewById(R.id.button3);

    _txtEmail=(EditText)findViewById(R.id.inscriptionAdresseMail);
    _txtUser=(EditText)findViewById(R.id.InscriptionPseudo);
    _txtPass=(EditText)findViewById(R.id.MotDePasse);

    _btnReg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String email = _txtEmail.getText().toString();
        String username = _txtUser.getText().toString();
        String password = _txtPass.getText().toString();
        String type = "reg";

        BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
        backgroundTask.execute(type, email, username, password);

      }
    });
  }
}

package com.example.projet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class identification extends AppCompatActivity {

Button _btnLog;
EditText _addMail, _addPassword;

@Override
protected void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.identification);

  _btnLog=findViewById(R.id.button3);
  _addMail=findViewById(R.id.ConnexionAdresseMail);
  _addPassword=findViewById(R.id.editTextTextPassword2);

  _btnLog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      String user_name=_addMail.getText().toString();
      String pass_word=_addPassword.getText().toString();
      String type="login";
      BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
      backgroundTask.execute(type, user_name, pass_word);

      }
    });
  }
}
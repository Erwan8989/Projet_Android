package com.example.projet;

  import androidx.appcompat.app.AppCompatActivity;

  import android.app.Activity;
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.Button;

public class connexion_inscription extends Activity {

  String url ="https://api.github.com/zen";
  Button b10;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.connexion_inscription);

  }


}

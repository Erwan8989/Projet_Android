package com.example.projet;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class conversations_liste extends AppCompatActivity {


    private EditText text;
    private Button save, viewData;
    private String SendUrl = "https://ip";
    private requestQueue requestQueue;
    private static final String TAG=conversations_liste.class.getSimpleName();
    int sucess;
    private String TAG_SUCESS;
    private String TAG_MESSAGE;
    private String tag_json_obj="json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversations_liste);

        text = findViewById(R.id.text);
        viewData=findViewById(R.id.viewdata);
        save=findViewById(R.id.btnsave)
    };

  private Map<String, String> sendData () {
    StringRequest request = new StringRequest (Request.Method.POST, sendUrl, new Response Listener <String>(){
      @Override
      public void onResponse(String Response){
        try{
          /* String response = null; */
          JSONObject jobj = new JSONObject(response);
          sucess = jobj.getInt(TAG_SUCESS);
          if(sucess==1){
            Toast.makeText(conversations_liste.this,jobj.getString(TAG_MESSAGE),Toast.LENGTH_SHORT).show();
          }else{
            Toast.makeText(conversations_liste.this,jobj.getString(TAG_MESSAGE),Toast.LENGTH_SHORT).show();
          }
        }catch(Exception e){
          Toast.makeText(conversations_liste.this,"Error Occured"+e,Toast.LENGTH_SHORT).show();
        }
      }
    }, new Response.errorListener (){
      @Override
      public void onErrorResponse(VolleyError error){

        Toast.makeText(conversations_liste.this,error getMessage().toString(),Toast.LENGTH_SHORT).show();
      }
    }) {
      public Map<String, String> getParams(){
        Map <String, String> params = new HashMap<String, String>();
        params.put ("username", text.getText().ToString());
        params.put ("username", text.getText().ToString());
        return params;


      };

      request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0)) ;
      requestQueue.add(request);

    }










}

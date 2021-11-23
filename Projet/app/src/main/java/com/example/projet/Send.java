package com.example.projet;

import static android.os.Build.VERSION_CODES.O;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;


public class Send extends AppCompatActivity {

  private Object Exeption;

  private void getData(){
    StringRequest stringRequest=new StringRequest(Request.Method.GET.getData, new Response.Listener<String>(){
      public void Onresponse(String response);
    for(int i=O;i<array.length();i++){
        JSONObject array;
        JSONObject data=array.getJSONObject(i);
        String message=data.getString("message");
        String date=data.getString("date");
        message.setText(message);
        date.setText(date);
      }
    }catch (Exeption e){

    }
  }, new Response.ErrorListener(){
    @Override
    public void OnErrorResponse(VolleyError error){

    }
  });

}

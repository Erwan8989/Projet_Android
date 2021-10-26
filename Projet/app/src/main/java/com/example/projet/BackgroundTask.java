package com.example.projet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class BackgroundTask extends AsyncTask <String, String, String> {
        @SuppressLint("StaticFieldLeak")
        Context context;
        BackgroundTask(Context ctx){
        context = ctx;
        }

@Override
protected String doInBackground(String... strings) {
        String type=strings[0];
        String loginURL="http://127.0.0.1/login.php";             // Mettre son adresse public
        String regURL="http://127.0.0.1/insc.php";                 // Mettre son adresse public

        if (type.equals("reg")){
        String email= strings[1];
        String username=strings[2];
        String password=strings[3];

        try{
                URL url= new URL(regURL);
        try{
                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String insert_data = "&amp;"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+
                "&amp;"+URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+
                "&amp;"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(insert_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream= httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String result="";
                String line="";
                StringBuilder stringBuilder= new StringBuilder();
                while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line).append("\n");

                }
                result=stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
        } catch (IOException e) {
                e.printStackTrace();
        }
        } catch (MalformedURLException e) {
                e.printStackTrace();
        }
        } else if(type.equals("login")) {
                String user_name = strings[1];
                String pass_word = strings[2];
                try {
                        URL url = new URL(loginURL);
                try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                        String login_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") +
                        "&amp;" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8");

                        bufferedWriter.write(login_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        String result = "";
                        String line = "";
                        StringBuilder stringBuilder = new StringBuilder();

                        while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n"); }

                        result = stringBuilder.toString();
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;

                } catch (IOException e) {
                        e.printStackTrace();
                }
                } catch (MalformedURLException e) {
                        e.printStackTrace();
                }
        }

        return null;
        }

@Override
protected void onPreExecute() {
        super.onPreExecute();
        }

@Override
protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
//super.onPostExecute(s);
        }

}
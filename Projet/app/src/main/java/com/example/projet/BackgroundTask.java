package com.example.projet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.w3c.dom.Text;

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

public abstract class BackgroundTask extends AsyncTask<String, String, String> {
        @SuppressLint("StaticFieldLeak")
        Context context;
        BackgroundTask(Context ctx){
        this.context = ctx;
        }

@Override
protected String doInBackground(Text... strings) {
        Text type=strings[0];
        String loginURL="http://10.0.2.2/android/login.php";             // Mettre son adresse ip
        String regURL="http://10.0.2.2/android/insc.php";                 // Mettre son adresse ip

        if (type.equals("reg")){
                Text email=strings[1];
                Text username=strings[2];
                Text password=strings[3];

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

                        String insert_data = "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(String.valueOf(email), "UTF-8")+
                        "&"+URLEncoder.encode("pseudo", "UTF-8")+"="+URLEncoder.encode(String.valueOf(username), "UTF-8")+
                        "&"+URLEncoder.encode("mdp", "UTF-8")+"="+URLEncoder.encode(String.valueOf(password), "UTF-8");

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
                        stringBuilder.append(line).append("\n"); }

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
                Text user_name = strings[1];
                Text pass_word = strings[2];
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

                                String login_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(user_name), "UTF-8") +
                                "&" + URLEncoder.encode("mdp", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(pass_word), "UTF-8");

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
                        e.printStackTrace(); }

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
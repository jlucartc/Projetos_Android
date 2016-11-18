package com.example.luca.banco;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.luca.banco.R.id.imageError;

/**
 * Created by Luca on 16/11/2016.
 */

public class AsynClass extends AsyncTask<String,String,String> {

    private String user;
    private Boolean isValid;

    @Override
    protected String doInBackground(String... params) {

        String user = validateLogin(params[0],params[1]);
        return null;
    }

    public String validateLogin(String login, String password) {

        try {

            URL url = new URL("http://192.168.25.13/BancoQuestaoWS/connect.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();

            String data = "lvar="+ Base64.encodeToString(login.getBytes(),Base64.DEFAULT)+"&svar="+Base64.encodeToString(password.getBytes(),Base64.DEFAULT);

            os.write(data.getBytes());

            os.close();

            InputStream io = new BufferedInputStream(conn.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(io));

            StringBuffer sb =  new StringBuffer();

            String line;

            while((line = reader.readLine()) != null){
                sb.append(line);
            }

            user = parseJson(sb.toString());



            if(user != null){

                this.isValid = true;
                return null;

            }else{
                this.isValid = false;
                return null;
            }



        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.isValid = false;
        return null;

    }


    public String parseJson(String string){

        try {
            JSONArray conteudo = new JSONArray(string);
            JSONObject isValidObj = conteudo.getJSONObject(0);
            Boolean isValid = isValidObj.getBoolean("isValid");
            if(isValid){

                JSONObject userObj = conteudo.getJSONObject(1);
                String user = userObj.getString("usuario");

                return user;

            }else{

                return null;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean isValid(){
        return this.isValid;
    }

    public String getUser(){
        return user;
    }

}

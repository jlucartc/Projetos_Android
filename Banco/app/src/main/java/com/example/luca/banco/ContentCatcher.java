package com.example.luca.banco;

import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ArrayAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Luca on 17/11/2016.
 */

public class ContentCatcher extends AsyncTask<ArrayAdapter<Questao>,String,String> {

    private String subject;

    public ContentCatcher(String subject){
        this.subject = subject;
    }

    @Override
    protected String doInBackground(ArrayAdapter<Questao>... params) {

        try {
            URL url = new URL("http://192.168.25.13/BancoQuestaoWS/getContent.php");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("POST");

            String data = "subject="+ Base64.encodeToString(this.subject.getBytes(),Base64.DEFAULT);

            OutputStream os = conn.getOutputStream();

            os.write(data.getBytes());

            os.flush();

            os.close();

            InputStream is = new BufferedInputStream(conn.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuffer sb = new StringBuffer();

            String line;

            while((line = reader.readLine()) != null){

                sb.append(line);

            }

            //parse json

            return null;

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            return null;

    }
}

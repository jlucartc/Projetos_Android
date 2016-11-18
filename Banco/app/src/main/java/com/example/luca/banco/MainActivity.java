package com.example.luca.banco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText login;
    private EditText password;
    private Button loginButton;
    private ImageView imageError;
    private TextView errorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.loginButton);
        imageError = (ImageView)findViewById(R.id.imageError);
        errorMessage = (TextView)findViewById(R.id.errorMessage);
        loginButton.setOnClickListener(this);
        login.setOnClickListener(this);
        password.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("SharedPreferences",Context.MODE_PRIVATE);
        Boolean isLoggedIn = sp.getBoolean("isLoggedIn",false);

        if(isLoggedIn){
            String user = sp.getString("user",null);
            Intent i = new Intent(this,Home.class);
            i.putExtra("user",user);
            startActivity(i);
            finish();
        }else{
        }

    }


    @Override
    public void onClick(View v) {
        if(v == loginButton){
                AsynClass ac = new AsynClass();
                ac.execute(login.getText().toString(),password.getText().toString());
                while(ac.isValid() == null){/*System.out.println("...");*/}
                System.out.println("OK");
                if(ac.isValid()){
                    String user = ac.getUser();
                    SharedPreferences sp = getSharedPreferences("SharedPreferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("user",user);
                    editor.putBoolean("isLoggedIn",true);
                    editor.commit();
                    Intent i = new Intent(this,Home.class);
                    i.putExtra("user",user);
                    startActivity(i);
                    finish();
                }else{
                    errorMessage.setText(R.string.error_string);
                    errorMessage.setVisibility(View.VISIBLE);
                    imageError.setImageResource(R.mipmap.error);
                    imageError.setVisibility(View.VISIBLE);
                    System.out.println("invalido");
                }

        }

        if(v == login){

            login.setText("");

        }

        if(v == password){

            password.setText("");

        }

    }
}

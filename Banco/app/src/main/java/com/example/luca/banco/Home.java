package com.example.luca.banco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

public class Home extends AppCompatActivity implements View.OnClickListener{

    private Button logoutButton;
    private Button mat;
    private Button port;
    private Button quim;
    private Button fis;
    private Button hist;
    private Button inserirQuestao;
    private ListView listaMat;
    private ListView listaPort;
    private ListView listaQuim;
    private ListView listaFis;
    private ListView listaHist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logoutButton = (Button)findViewById(R.id.logoutButton);
        mat = (Button)findViewById(R.id.mat);
        port = (Button)findViewById(R.id.port);
        quim = (Button)findViewById(R.id.quim);
        fis = (Button)findViewById(R.id.fis);
        hist = (Button)findViewById(R.id.hist);
        inserirQuestao = (Button)findViewById(R.id.inserirQuestao);

        //listaMat = (ListView)findViewById(R.id.listaMat);
        //listaPort = (ListView)findViewById(R.id.listaPort);
        //listaQuim = (ListView)findViewById(R.id.listaQuim);
        //listaFis = (ListView)findViewById(R.id.listaFis);
        //listaHist = (ListView)findViewById(R.id.listaHist);


        logoutButton.setOnClickListener(this);
        mat.setOnClickListener(this);
        port.setOnClickListener(this);
        quim.setOnClickListener(this);
        fis.setOnClickListener(this);
        hist.setOnClickListener(this);
        inserirQuestao.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == logoutButton){

            SharedPreferences sp = getSharedPreferences("SharedPreferences",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isLoggedIn",false);
            editor.putString("user",null);
            editor.commit();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();

        }

        if(v == mat){

            if(listaMat.getAdapter() == null){
                /*try {
                    listaMat.setAdapter(new ContentCatcher("Matematica").execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }else{

            }

        }

        if(v == port){
            if(listaPort.getAdapter() == null){
                /*try {
                    listaMat.setAdapter(new ContentCatcher().execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }else{

            }
        }

        if(v == quim){
            if(listaQuim.getAdapter() == null){
                /*try {
                    listaMat.setAdapter(new ContentCatcher().execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }else{

            }
        }

        if(v == fis){
            if(listaFis.getAdapter() == null){
                /*try {
                    listaMat.setAdapter(new ContentCatcher().execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }else{

            }
        }

        if(v == hist){
            if(listaHist.getAdapter() == null){
                /*try {
                    listaMat.setAdapter(new ContentCatcher().execute().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }else{

            }
        }

        if(v == inserirQuestao){
            startActivity(new Intent(this,InserirQuestao.class));
        }

    }
}

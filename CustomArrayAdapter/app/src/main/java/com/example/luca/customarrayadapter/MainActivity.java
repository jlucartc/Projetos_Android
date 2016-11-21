package com.example.luca.customarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button adicionar;
    private Button remover;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<Alternativa> arraylist;
    private String[] arrayLetras;
    private int nAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adicionar = (Button)findViewById(R.id.adicionar);
        remover = (Button)findViewById(R.id.remover);
        listView = (ListView)findViewById(R.id.listView);
        arraylist = new ArrayList<Alternativa>();
        adapter = new AlternativaAdapter(this,R.layout.alternativa_layout,arraylist);
        arrayLetras = new String[]{"A","B","C","D","E"};
        nAlt = 0;

        adicionar.setOnClickListener(this);
        remover.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == adicionar){
            if(nAlt < 5) {
                arraylist.add(new Alternativa(arrayLetras[nAlt], "Texto " + (nAlt + 1)));
                nAlt++;
                listView.setAdapter(adapter);
            }
        }

        if(v == remover){
            if(nAlt > 0){
                arraylist.remove(arraylist.get(arraylist.size()-1));
                nAlt--;
                listView.setAdapter(adapter);
            }

        }


    }
}

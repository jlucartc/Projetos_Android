package com.example.luca.linearinsteadoflist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Alternativa> arrayList;
    private ArrayAdapter<Alternativa> adapter;
    private LinearLayout alternativas;
    private Button adicionar;
    private Button remover;
    private Button enviar;
    private String[] array;
    private int nAlt;
    private int lastFreeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Alternativa>();
        adapter = new MyAdapter(this,R.layout.item_layout,arrayList);
        alternativas = (LinearLayout)findViewById(R.id.alternativas);
        adicionar = (Button)findViewById(R.id.adicionar);
        remover = (Button)findViewById(R.id.remover);
        enviar = (Button)findViewById(R.id.enviar);

        array = new String[]{"A","B","C","D","E"};
        nAlt = 0;
        lastFreeIndex = 0;

        adicionar.setOnClickListener(this);
        remover.setOnClickListener(this);
        enviar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == adicionar){

            arrayList.add(new Alternativa(array[nAlt],"Texto da alternativa"));
            nAlt++;
            alternativas.addView(adapter.getView(arrayList.size()-1,null,null),lastFreeIndex);
            lastFreeIndex++;

        }
        if(v == remover){
            arrayList.remove(arrayList.size()-1);
            nAlt--;
            alternativas.removeViewAt(lastFreeIndex-1);
            lastFreeIndex--;

        }
        if(v == enviar){

        }
    }
}

package com.example.luca.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class InserirQuestao extends AppCompatActivity implements View.OnClickListener{

    private int nAlt;
    private String[] altArray;
    private Spinner areasSpinner;
    private Spinner respostaSpinner;
    private Button addAlt;
    private Button removeAlt;
    private Button enviar;
    private ListView listView;
    private ArrayAdapter listViewAdapter;
    private ArrayList<Object> listViewAdapterObjArray;
    private ArrayAdapter respostasAdapter;
    private ArrayList<Object> respostasAdapterObjArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_questao);

        nAlt = 0;
        altArray = new String[]{"A", "B", "C", "D", "E"};

        addAlt = (Button)findViewById(R.id.addAlt);
        removeAlt = (Button)findViewById(R.id.removeAlt);
        enviar = (Button)findViewById(R.id.enviar);
        areasSpinner = (Spinner)findViewById(R.id.areasSpinner);
        respostaSpinner = (Spinner)findViewById(R.id.respostaSpinner);
        listView = (ListView)findViewById(R.id.listView);
        listViewAdapter = new ArrayAdapter(this,R.layout.list_view_layout,R.id.altLetter);
        listViewAdapterObjArray = new ArrayList<Object>();
        respostaSpinner = (Spinner)findViewById(R.id.respostaSpinner);

        respostasAdapterObjArray = new ArrayList();

        addAlt.setOnClickListener(this);
        removeAlt.setOnClickListener(this);
        enviar.setOnClickListener(this);

        respostasAdapter =  new ArrayAdapter(this,R.layout.respostas_list_view_item_layout,R.id.respostas_list_view_item_layout_text);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.areas,R.layout.support_simple_spinner_dropdown_item);
        areasSpinner.setAdapter(adapter);
        respostaSpinner.setAdapter(respostasAdapter);

    }

    @Override
    public void onClick(View v) {
        System.out.println("nAlt: "+nAlt);
        if(v == addAlt){
            if(nAlt < 5) {
                listViewAdapter.add(altArray[nAlt]);
                respostasAdapter.add(altArray[nAlt]);
                nAlt++;
                listViewAdapterObjArray.add(listViewAdapter.getItem(listViewAdapter.getCount() - 1));
                respostasAdapterObjArray.add(respostasAdapter.getItem(respostasAdapter.getCount() - 1));
                listView.setAdapter(listViewAdapter);

            }else{
            }
        }

        if(v == removeAlt){
            if(nAlt > 0) {
                listViewAdapter.remove(listViewAdapterObjArray.get(listViewAdapterObjArray.size() - 1));
                respostasAdapter.remove(respostasAdapterObjArray.get(respostasAdapterObjArray.size() - 1));
                listViewAdapterObjArray.remove(listViewAdapterObjArray.size() - 1);
                respostasAdapterObjArray.remove(respostasAdapterObjArray.size() - 1);
                listView.setAdapter(listViewAdapter);
                respostaSpinner.setAdapter(respostasAdapter);
                nAlt--;
            }else{

            }
        }

        if(v == enviar){

        }
    }
}

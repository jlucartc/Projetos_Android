package com.example.luca.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InserirQuestao extends AppCompatActivity implements View.OnClickListener{

    private Spinner area;
    private EditText texto;
    private EditText instituicao;
    private Button adicionar;
    private Button remover;
    private LinearLayout alternativas;
    private Spinner resposta;
    private Button enviar;

    private ArrayList<Alternativa> arrayList;
    private ArrayAdapter<Alternativa> adapter;
    private ArrayList<String> respostaArrayList;
    private ArrayAdapter<String> respostaAdapter;

    private String[] letras;
    private int nAlt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_inserir_questao);
        setContentView(R.layout.new_inserir_questao);

        area = (Spinner)findViewById(R.id.area);
        texto = (EditText)findViewById(R.id.texto);
        instituicao = (EditText)findViewById(R.id.instituicao);
        adicionar = (Button)findViewById(R.id.adicionar);
        remover = (Button)findViewById(R.id.remover);
        alternativas = (LinearLayout)findViewById(R.id.alternativas);
        resposta = (Spinner)findViewById(R.id.resposta);
        enviar = (Button)findViewById(R.id.enviar);

        arrayList = new ArrayList<Alternativa>();
        adapter = new MyAdapter(this,R.layout.list_view_layout,arrayList);
        respostaArrayList = new ArrayList<String>();
        respostaAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,respostaArrayList);
        ArrayAdapter areaAdapter = ArrayAdapter.createFromResource(this,R.array.areas,R.layout.support_simple_spinner_dropdown_item);
        areaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        area.setAdapter(areaAdapter);

        letras = new String[]{"A", "B", "C", "D", "E"};
        nAlt = 0;

        System.out.println(alternativas == null);

        adicionar.setOnClickListener(this);
        remover.setOnClickListener(this);

        respostaAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        resposta.setAdapter(respostaAdapter);

    }

    @Override
    public void onClick(View v) {
        if(v == adicionar){
            if(nAlt < 5) {
                Alternativa a = new Alternativa(letras[nAlt], "Texto da alternativa");
                arrayList.add(a);
                respostaArrayList.add(letras[nAlt]);
                nAlt++;
                alternativas.addView(adapter.getView(arrayList.size()-1,null,null));
                System.out.println("----------\n\n");
                resposta.setAdapter(respostaAdapter);
            }else{
            }
        }

        if(v == remover){
            if(nAlt > 0) {

                alternativas.removeViewAt(arrayList.size()-1);
                arrayList.remove(arrayList.get(arrayList.size()-1));
                respostaArrayList.remove(respostaArrayList.get(respostaArrayList.size()-1));
                nAlt--;
                resposta.setAdapter(respostaAdapter);

            }else{

            }
        }

        if(v == enviar){
            /*HashMap<String,String> hm = new HashMap<String,String>();
            for(int i = 0; i < nAlt; i++){
                EditText edit = (EditText) alternativasListViewAdapter.getView(1,null,null).findViewById(R.id.listViewEdit);
                hm.put(altArray[i],edit.getText().toString());
            }
            String area = areasSpinner.getSelectedItem().toString();
            int areaInt = 0;
            if(area.equals("Matemática")){
                areaInt = 1;
            }else if(area.equals("Português")){
                areaInt = 2;
            }else if(area.equals("Química")){
                areaInt = 3;
            }else if(area.equals("Física")){
                areaInt = 4;
            }else if(area.equals("História")){
                areaInt = 5;
            }

            Questao q = new Questao(areaInt,textoEdit.getText().toString(),instituicaoEdit.getText().toString(),false,hm,respostaSpinner.getSelectedItem().toString());

            JSONObject map = new JSONObject();

            Set keys = hm.keySet();

            for ( Object o : keys ) {
                try {
                    map.put((String)o,hm.get(o));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            JSONObject questao = new JSONObject();

            try {
                questao.put("area",areaInt);
                questao.put("texto",textoEdit.getText().toString());
                questao.put("instituicao",instituicaoEdit.getText().toString());
                questao.put("estado",0);
                questao.put("alternativas",map);
                questao.put("resposta",respostaSpinner.getSelectedItem().toString());

                JSONObject json = new JSONObject();

                json.put("area",areaInt);
                json.put("aprovada",0);
                json.put("questao",questao);

                URL url = new URL("http://192.168.25.13/BancoQuestoesWS/insert.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");

                System.out.println(json.toString());

                /*String data = "json="+json.toString();

                OutputStream os = conn.getOutputStream();

                os.write(data.getBytes());
                os.flush();
                os.close();*/

            /*
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            */
        }
    }
}

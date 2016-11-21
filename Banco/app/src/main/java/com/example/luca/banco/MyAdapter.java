package com.example.luca.banco;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Luca on 18/11/2016.
 */

public class MyAdapter extends ArrayAdapter<Alternativa>{

    private ArrayList<Alternativa> objects;
    private int resourceId;

    public MyAdapter(Context context, int resourceId, ArrayList<Alternativa> objects){
        super(context,resourceId,objects);

        this.objects = objects;
        this.resourceId = resourceId;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(resourceId,null);

            Alternativa i = objects.get(position);

            System.out.println("Position: "+position);
            System.out.println("Letra: "+i.getLetra());

            if(i != null){

                TextView letra = (TextView)v.findViewById(R.id.altLetter);
                EditText texto = (EditText)v.findViewById(R.id.listViewEdit);

                letra.setText(i.getLetra());
                texto.setText(i.getTexto());

            }

        }else{

        }

        return v;

    }
}
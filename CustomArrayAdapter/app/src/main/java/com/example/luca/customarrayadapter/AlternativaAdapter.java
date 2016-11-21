package com.example.luca.customarrayadapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luca on 20/11/2016.
 */

public class AlternativaAdapter extends ArrayAdapter<Alternativa> {

    private ArrayList<Alternativa> objects;
    private int resourceId;

    public AlternativaAdapter(Context context, int resourceId, ArrayList<Alternativa> array){
        super(context,resourceId,array);
        objects = array;
        this.resourceId = resourceId;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){

            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(resourceId,null);

            Alternativa i = objects.get(position);

            System.out.println("Position: "+position);

            if(i != null){

                System.out.println("Letra: "+i.getLetra());

                TextView alternativaLetra = (TextView)v.findViewById(R.id.alternativaLetra);
                EditText alternativaTexto = (EditText)v.findViewById(R.id.alternativaTexto);

                alternativaLetra.setText(i.getLetra());
                alternativaTexto.setText(i.getTexto());

            }

        }else{

        }

        return v;
    }
}

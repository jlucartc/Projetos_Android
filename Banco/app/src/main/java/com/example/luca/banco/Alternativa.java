package com.example.luca.banco;

import android.support.v7.app.AlertDialog;

/**
 * Created by Luca on 20/11/2016.
 */

public class Alternativa {

    private String letra;
    private String texto;

    public Alternativa(String letra, String texto){

        this.letra = letra;
        this.texto = texto;

    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

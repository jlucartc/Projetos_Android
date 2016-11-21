package com.example.luca.customarrayadapter;

/**
 * Created by Luca on 20/11/2016.
 */

public class Alternativa {

    private String letra;
    private String texto;

    public Alternativa(String l, String t){

        this.letra = l;
        this.texto = t;

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

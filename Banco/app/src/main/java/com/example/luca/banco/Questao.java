package com.example.luca.banco;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Luca on 17/11/2016.
 */

public class Questao implements Serializable {

    private int id;
    private int area;
    private String texto;
    private String instituicao;
    private Boolean aprovada;
    private HashMap<String,String> alternativas;
    private String resposta;

    public Questao(int area,String texto,String instituicao,Boolean aprovada,HashMap<String,String> alternativas,String resposta){
        this.area = area;
        this.texto = texto;
        this.instituicao = instituicao;
        this.aprovada = aprovada;
        this.alternativas = alternativas;
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada(Boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public HashMap<String, String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(HashMap<String, String> alternativas) {
        this.alternativas = alternativas;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}

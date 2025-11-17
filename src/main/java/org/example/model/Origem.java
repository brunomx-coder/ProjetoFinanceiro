package org.example.model;

import org.example.util.ValidacaoUtil;

public class Origem extends Modelos{
    ValidacaoUtil valida = new ValidacaoUtil();
    private int id;
    private String nome;
    private String tipo;

    public Origem(String nome, String tipo){
        setNome(nome);
        setTipo(tipo);
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome){
        super.verificacao(nome);
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipo(String tipo){
        super.verificacao(tipo);
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString() {
        String mensagem = "Id: " + this.id + "\nNome: " + this.nome + "\nTipo: " + this.tipo;
        return mensagem;
    }
}

package org.example.model;

public class Origem {
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
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipo(String tipo){
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

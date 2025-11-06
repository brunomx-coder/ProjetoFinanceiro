package org.example.model;

public class Categoria {
    private int id;
    private String nome;
    private String tipoMovimento;

    public Categoria(String nome, String tipoMovimento) {
        setNome(nome);
        setTipoMovimento(tipoMovimento);
    }

    public int getId(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipoMovimento(String tipo){
        this.tipoMovimento = tipo;
    }

    public String getTipoMovimento(){
        return this.tipoMovimento;
    }

    @Override
    public String toString() {
        String mensagem = "Id: " + this.id + "\nNome: " + this.nome + "\nTipo de movimento: " + this.tipoMovimento;
        return mensagem;
    }
}

package org.example.model;

import org.example.util.ValidacaoUtil;

public class Categoria extends Modelos {
    ValidacaoUtil valida = new ValidacaoUtil();

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
        super.verificacao(nome);
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipoMovimento(String tipo){
        super.verificacao(tipo);
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

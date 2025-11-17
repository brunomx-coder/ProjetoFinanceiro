package org.example.model;

import java.util.Date;

public class Transacao extends Modelos {
    private int id;
    private Date data;
    private String descricao;
    private String tipo;
    private String parcela;
    private String fixaOuVariavel;
    private double valor;
    Origem origem;
    Categoria categoria;

    public Transacao(Date data, String descricao, String tipo, String fixaOuVariavel, double valor, String nomeCategoria, String tipoCategoria, String nomeOrigem, String tipoOrigem){
        setData(data);
        setDescricao(descricao);
        setTipo(tipo);
        setFixaOuVariavel(fixaOuVariavel);
        setValor(valor);
        setCategoria(nomeCategoria, tipoCategoria);
        setOrigem(nomeOrigem, tipoOrigem);
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        super.verificacao(descricao);
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        super.verificacao(data);
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        super.verificacao(tipo);
        this.tipo = tipo;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        super.verificacao(parcela);
        this.parcela = parcela;
    }

    public String getFixaOuVariavel() {
        return fixaOuVariavel;
    }

    public void setFixaOuVariavel(String fixaOuVariavel) {
        super.verificacao(fixaOuVariavel);
        this.fixaOuVariavel = fixaOuVariavel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        super.verificacao(valor);
        this.valor = valor;
    }

    public void setOrigem(String nome, String tipo){
        origem = new Origem(nome, tipo);
    }

    public Origem getOrigem() {
        return this.origem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(String nome, String tipo) {
        this.categoria = new Categoria(nome, tipo);
    }
}

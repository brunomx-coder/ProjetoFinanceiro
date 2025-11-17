package org.example.model;

import org.example.util.ValidacaoUtil;

import java.util.Date;

public class Modelos {
    ValidacaoUtil valida = new ValidacaoUtil();

    public void verificacao(String dado){
        if(valida.verificacaoEntrada(dado)){
            throw new IllegalArgumentException("Erro: Entrada inválida.");
        }
    }

    public void verificacao(Double dado){
        if(valida.verificacaoEntrada(dado)){
            throw new IllegalArgumentException("Erro: Entrada inválida.");
        }
    }

    public void verificacao(Date dado){
        if(valida.verificacaoEntrada(dado)){
            throw new IllegalArgumentException("Erro: Entrada inválida.");
        }
    }

}

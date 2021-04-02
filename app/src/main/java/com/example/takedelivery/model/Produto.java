package com.example.takedelivery.model;

import java.math.BigDecimal;

public class Produto {
    int id;
    String nome;
    String descricao;
    Float preco;
    private static int contadorId = 0;


    public Produto(int id, String nome, String descricao, Float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.id = id;

    }

    public Produto() {
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco( Float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}

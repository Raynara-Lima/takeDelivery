package com.example.takedelivery.model;

import java.util.ArrayList;

public class Empresa {
    int id;
    String cnpj;
    String nomeFantasia;
    String telefone;
    String cep;
    String estado;
    String cidade;
    String bairro;
    String endereco;
    String numero;
    ArrayList<Produto> cardapio;
    Categoria categoria;

    public Empresa(String cnpj, String nomeFantasia, String telefone, String cep, String estado, String cidade, String bairro, String endereco,String numero, Categoria categoria) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.categoria = categoria;

    }

    public Empresa() {
    }

    public int getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

//    public String getRazaoSocial() {
//        return razaoSocial;
//    }
//
//    public void setRazaoSocial(String razaoSocial) {
//        this.razaoSocial = razaoSocial;
//    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Produto> getCardapio() {
        return cardapio;
    }

    public void setCardapio(ArrayList<Produto> cardapio) {
        this.cardapio = cardapio;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNúmero() {
        return numero;
    }

    public void setNumero(String núuero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

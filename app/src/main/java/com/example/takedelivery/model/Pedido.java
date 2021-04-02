package com.example.takedelivery.model;

import com.example.takedelivery.StatusPedido;

public class Pedido {
    private static int contadorId = 0;

    int id;
    String nomeCliente; //mudar para objeto cliente
    String data;
    String hora;
    String endereco;
    String numero;
    String metodoDePagamento;
    StatusPedido status;

    public Pedido(String nomeCliente, String data, String hora, String endereco, String numero, String metodoDePagamento) {
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.hora = hora;
        this.endereco = endereco;
        this.numero = numero;
        this.metodoDePagamento = metodoDePagamento;
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(String metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", metodoDePagamento='" + metodoDePagamento + '\'' +
                '}';
    }
}

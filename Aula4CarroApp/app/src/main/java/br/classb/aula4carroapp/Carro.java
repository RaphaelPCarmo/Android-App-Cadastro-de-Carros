package br.classb.aula4carroapp;

public class Carro {
    private String placa;
    private String modelo;
    private String cor;
    private String ano;
    private String estado;

    public Carro(String placa, String modelo, String cor, String ano, String estado) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return placa + " - " + modelo + " - " + cor + " - " + ano + " - " + estado;
    }
}

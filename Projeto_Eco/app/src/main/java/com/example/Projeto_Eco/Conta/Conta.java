package com.example.Projeto_Eco.Conta;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Conta implements Serializable {
    private int id=0;
    private String nome;
    private String consumo_mensal;
    private String potencia;
    private String horas_uso;
    private String preco_kWh;
    private String preco_consumo;

    public Conta(String nome, String horas_uso, String potencia, String preco_kWh, String preco_consumo,String consumo_mensal){
        this.nome = nome;
        this.horas_uso = horas_uso;
        this.potencia = potencia;
        this.preco_kWh = preco_kWh;
        this.consumo_mensal = consumo_mensal;
        this.preco_consumo = preco_consumo;
    }
public Conta(){

}
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConsumo_mensal(String consumo_mensal) {
        this.consumo_mensal = consumo_mensal;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public void setHoras_uso(String horas_uso) {
        this.horas_uso = horas_uso;
    }

    public void setPreco_kWh(String preco_kWh) {
        this.preco_kWh = preco_kWh;
    }

    public void setPreco_consumo(String preco_consumo) {
        this.preco_consumo = preco_consumo;
    }

    public String getNome() {
        return nome;
    }

    public String getConsumo_mensal() {
        return consumo_mensal;
    }

    public String getPotencia() {
        return potencia;
    }

    public String getHoras_uso() {
        return horas_uso;
    }

    public String getPreco_kWh() {
        return preco_kWh;
    }

    public String getPreco_consumo() {
        return preco_consumo;
    }

    @NonNull
    @Override

    public String toString() {
        return nome + " - ";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean temIdValido(){return id > 0;}
}

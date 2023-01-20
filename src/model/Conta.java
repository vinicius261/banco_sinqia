package model;

import enums.TipoDeConta;

public abstract class Conta {

    private String numeroConta, senha;
    private double saldo;
    private Cliente cliente;
    private TipoDeConta tipoDeConta;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }
}

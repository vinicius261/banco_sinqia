package model;

import enums.TipoDeConta;

public abstract class Conta {

    private String numeroConta;
    private double saldo;
    private Cliente cliente;
    private TipoDeConta tipoDeConta;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

    protected Conta() {
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
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

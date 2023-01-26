package model;

import enums.TipoDeConta;

public abstract class Conta {

    private String numeroConta, senha;
    private double saldo;
    private Cliente cliente;
    private TipoDeConta tipoDeConta;

    public Conta(
            String numeroConta,
            String senha,
            double saldo,
            Cliente cliente
    ){
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Conta(){

    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }
}

package model;

import enums.TipoDeConta;

public abstract class Conta {

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
        this.tipoDeConta = tipoDeConta;
    }

    public Conta(){

    }

    private String numeroConta, senha;
    private double saldo;
    private Cliente cliente;
    private TipoDeConta tipoDeConta;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setTipoDeConta(TipoDeConta tipoDeConta){
        this.tipoDeConta = tipoDeConta;
    }
    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }
}

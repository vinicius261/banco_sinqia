package model;

public abstract class Conta {

    String numeroConta;
    double saldo;
    Cliente cliente = new Cliente();

    protected Conta(String numeroConta, double saldo){
        this.numeroConta=numeroConta;
        this.saldo = saldo;
    }

}

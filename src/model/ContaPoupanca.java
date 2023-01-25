package model;

import enums.TipoDeConta;
import interfaces.Investir;

public class ContaPoupanca extends Conta  {

    private double rendimento;

    public ContaPoupanca(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        TipoDeConta tipoDeConta = TipoDeConta.CONTA_POUPANCA;
    }

    public ContaPoupanca(){

    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}


package model;

import enums.TipoDeConta;
import interfaces.Investir;

public class ContaPoupanca extends Conta {

    private double rendimento = 0.01;

    public ContaPoupanca(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        setTipoDeConta(TipoDeConta.CONTA_POUPANCA);
    }

    public ContaPoupanca() {

    }

    public double getRendimento() {
        return rendimento;
    }

}

package model;

import enums.TipoDeConta;
import interfaces.Investir;

public class ContaPoupanca extends Conta  {
    private TipoDeConta tipoDeConta = TipoDeConta.CONTA_POUPANCA;
    private double rendimento;


    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}


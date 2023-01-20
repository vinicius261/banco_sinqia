package model;

import enums.TipoDeConta;
import interfaces.Investir;

public class ContaInvestimento extends Conta  {

    private TipoDeConta tipoDeConta = TipoDeConta.CONTA_INVESTIMENTO;
    private double rendimento;

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}

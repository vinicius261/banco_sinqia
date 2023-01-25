package model;

import enums.TipoDeConta;
import interfaces.Investir;

public class ContaInvestimento extends Conta  {
    private double rendimento;

    private TipoDeConta tipoDeConta;

    public ContaInvestimento(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        this.tipoDeConta = TipoDeConta.CONTA_INVESTIMENTO;
    }

    public ContaInvestimento(){

    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}

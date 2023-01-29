package model;

import enums.TipoDeConta;

public class ContaInvestimento extends Conta {
    private final double rendimentoPessoaJuridica = 0.035;
    private final double rendimentoPessoaFisica = 0.015;

    public ContaInvestimento(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        setTipoDeConta(TipoDeConta.CONTA_INVESTIMENTO);
    }

    public ContaInvestimento() {

    }

    public double getRendimentoPessoaJuridica() {
        return rendimentoPessoaJuridica;
    }

    public double getRendimentoPessoaFisica() {
        return rendimentoPessoaFisica;
    }
}

package service;

import interfaces.Investir;
import database.BancoDeDados;
import model.Conta;
import model.ContaPoupanca;

public class ContaPoupancaService implements Investir {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    private BancoDeDados bancoDeDados;


    public ContaPoupancaService(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public double investir(double investimento, Conta conta) {
        double rendimento = investimento * contaPoupanca.getRendimento();
        conta.setSaldo(conta.getSaldo() + rendimento);
        return rendimento;
    }
}

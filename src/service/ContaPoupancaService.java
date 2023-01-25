package service;

import interfaces.Investir;
import database.BancoDeDados;
import model.Conta;
import model.ContaPoupanca;

public class ContaPoupancaService implements Investir {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public ContaPoupancaService(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }
    @Override
    public void investir(double investimento) {
        contaPoupanca.setRendimento(0.01);
        contaLogada.setSaldo(contaLogada.getSaldo()* contaPoupanca.getRendimento());
    }
}

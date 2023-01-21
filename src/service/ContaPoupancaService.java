package service;

import interfaces.Investir;
import database.BancoDeDados;
import model.ContaPoupanca;

public class ContaPoupancaService implements Investir {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    BancoDeDados bancoDeDados = new BancoDeDados();
    @Override
    public void investir(double investimento) {
        contaPoupanca.setRendimento(0.01);
        bancoDeDados.getContaLogada().setSaldo(bancoDeDados.getContaLogada().getSaldo()* contaPoupanca.getRendimento());
    }
}

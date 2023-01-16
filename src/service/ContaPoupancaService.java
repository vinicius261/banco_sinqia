package service;

import interfaces.Investir;
import model.Banco;
import model.ContaPoupanca;

public class ContaPoupancaService implements Investir {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    Banco banco = new Banco();
    @Override
    public void investir(double investimento) {
        contaPoupanca.setRendimento(0.01);
        banco.getUserLogado().setSaldo(banco.getUserLogado().getSaldo()* contaPoupanca.getRendimento());
    }
}

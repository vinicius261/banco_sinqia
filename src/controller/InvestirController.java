package controller;

import enums.TipoDeConta;
import database.BancoDeDados;
import model.Conta;
import service.ContaInvestimentoService;
import service.ContaPoupancaService;

public class InvestirController {
    private BancoDeDados bancoDeDados;

    public InvestirController(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public double tipoInvestimento(Conta conta, double investimento) {
        if (conta.getTipoDeConta().equals(TipoDeConta.CONTA_INVESTIMENTO)) {
            ContaInvestimentoService contaInvestimentoService = new ContaInvestimentoService(bancoDeDados, conta);
            return (contaInvestimentoService.investir(investimento, conta));
        } else if (conta.getTipoDeConta().equals(TipoDeConta.CONTA_POUPANCA)) {
            ContaPoupancaService contaPoupancaService = new ContaPoupancaService(bancoDeDados, conta);
            return (contaPoupancaService.investir(investimento, conta));
        }
        return 0;
    }
}

package controller;

import enums.TipoDeConta;
import database.BancoDeDados;
import service.ContaInvestimentoService;
import service.ContaPoupancaService;

public class InvestirController {
    BancoDeDados bancoDeDados = new BancoDeDados();

    public void tipoInvestimento(double investimento){
        if(bancoDeDados.getContaLogada().getTipoDeConta().equals(TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimentoService contaInvestimentoService = new ContaInvestimentoService();
            contaInvestimentoService.investir(investimento);
        } else if(bancoDeDados.getContaLogada().getTipoDeConta().equals(TipoDeConta.CONTA_POUPANCA)){
            ContaPoupancaService contaPoupancaService = new ContaPoupancaService();
            contaPoupancaService.investir(investimento);
        }

    }
}

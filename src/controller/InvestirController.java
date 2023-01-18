package controller;

import enums.TipoDeConta;
import model.Banco;
import service.ContaInvestimentoService;
import service.ContaPoupancaService;

public class InvestirController {
    Banco banco = new Banco();

    public void tipoInvestimento(double investimento){
        if(banco.getContaLogada().getTipoDeConta().equals(TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimentoService contaInvestimentoService = new ContaInvestimentoService();
            contaInvestimentoService.investir(investimento);
        } else if(banco.getContaLogada().getTipoDeConta().equals(TipoDeConta.CONTA_POUPANCA)){
            ContaPoupancaService contaPoupancaService = new ContaPoupancaService();
            contaPoupancaService.investir(investimento);
        }

    }
}

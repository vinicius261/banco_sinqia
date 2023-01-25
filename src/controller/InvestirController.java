package controller;

import enums.TipoDeConta;
import database.BancoDeDados;
import model.Conta;
import service.ContaInvestimentoService;
import service.ContaPoupancaService;

public class InvestirController {
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public InvestirController (BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void tipoInvestimento(double investimento){
        if(contaLogada.getTipoDeConta().equals(TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimentoService contaInvestimentoService = new ContaInvestimentoService(bancoDeDados, contaLogada);
            contaInvestimentoService.investir(investimento);
        } else if(contaLogada.getTipoDeConta().equals(TipoDeConta.CONTA_POUPANCA)){
            ContaPoupancaService contaPoupancaService = new ContaPoupancaService(bancoDeDados, contaLogada);
            contaPoupancaService.investir(investimento);
        }

    }
}

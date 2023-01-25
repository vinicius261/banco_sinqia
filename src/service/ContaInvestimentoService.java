package service;

import enums.TipoDeCliente;
import interfaces.Investir;
import database.BancoDeDados;
import model.Conta;
import model.ContaInvestimento;

public class ContaInvestimentoService implements Investir {
    ContaInvestimento contaInvestimento;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public ContaInvestimentoService(BancoDeDados bancoDeDados, Conta contaLogada){
        this.contaInvestimento = new ContaInvestimento();
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    @Override
    public void investir(double investimento) {

        if(contaLogada.getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_JURIDICA)){
            contaInvestimento.setRendimento(0.035);
            contaLogada.setSaldo(contaLogada.getSaldo()* contaInvestimento.getRendimento());

        } else if (contaLogada.getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_FISICA)){
            contaInvestimento.setRendimento(0.015);
            contaLogada.setSaldo(contaLogada.getSaldo()* contaInvestimento.getRendimento());
        }
    }
}

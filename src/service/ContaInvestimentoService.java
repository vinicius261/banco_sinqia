package service;

import enums.TipoDeCliente;
import interfaces.Investir;
import model.Banco;
import model.ContaInvestimento;

public class ContaInvestimentoService implements Investir {
    Banco banco = new Banco();
    ContaInvestimento contaInvestimento = new ContaInvestimento();

    @Override
    public void investir(double investimento) {
        if(banco.getUserLogado().getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_FISICA)){
            contaInvestimento.setRendimento(0.035);
            banco.getUserLogado().setSaldo(banco.getUserLogado().getSaldo()* contaInvestimento.getRendimento());

        } else if (banco.getUserLogado().getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_FISICA)){
            contaInvestimento.setRendimento(0.015);
            banco.getUserLogado().setSaldo(banco.getUserLogado().getSaldo()* contaInvestimento.getRendimento());

        }
    }
}

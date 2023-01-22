package service;

import enums.TipoDeCliente;
import interfaces.Investir;
import database.BancoDeDados;
import model.ContaInvestimento;

public class ContaInvestimentoService implements Investir {
    BancoDeDados bancoDeDados = BancoDeDados.banco();
    ContaInvestimento contaInvestimento = new ContaInvestimento();

    @Override
    public void investir(double investimento) {
        if(bancoDeDados.getContaLogada().getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_JURIDICA)){
            contaInvestimento.setRendimento(0.035);
            bancoDeDados.getContaLogada().setSaldo(bancoDeDados.getContaLogada().getSaldo()* contaInvestimento.getRendimento());

        } else if (bancoDeDados.getContaLogada().getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_FISICA)){
            contaInvestimento.setRendimento(0.015);
            bancoDeDados.getContaLogada().setSaldo(bancoDeDados.getContaLogada().getSaldo()* contaInvestimento.getRendimento());

        }
    }
}

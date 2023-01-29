package service;

import enums.TipoDeCliente;
import interfaces.Investir;
import database.BancoDeDados;
import model.Conta;
import model.ContaInvestimento;

public class ContaInvestimentoService implements Investir {
    ContaInvestimento contaInvestimento;
    private BancoDeDados bancoDeDados;


    public ContaInvestimentoService(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.contaInvestimento = new ContaInvestimento();
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public double investir(double investimento, Conta conta) {
        if (conta.getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_JURIDICA)) {
            double rendimento = investimento * contaInvestimento.getRendimentoPessoaJuridica();
            conta.setSaldo(conta.getSaldo() + rendimento);
            return rendimento;
        } else if (conta.getCliente().getTipoDeCliente().equals(TipoDeCliente.PESSOA_FISICA)) {
            double rendimento = investimento * contaInvestimento.getRendimentoPessoaFisica();
            conta.setSaldo(conta.getSaldo() + rendimento);
            return rendimento;
        }
        return 0;
    }
}

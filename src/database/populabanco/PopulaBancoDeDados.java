package database.populabanco;

import database.BancoDeDados;
import enums.TipoDeCliente;
import model.*;

import java.util.ArrayList;

public class PopulaBancoDeDados {

    private BancoDeDados bancoDeDados;

    public PopulaBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void CriarContasClientes() {

        Cliente clientePf = new Cliente(
                "José Almeida",
                "40541055054",
                "jose@email.com",
                TipoDeCliente.PESSOA_FISICA,
                new ArrayList<Conta>());
        bancoDeDados.addCliente(clientePf);

        Cliente clientePj = new Cliente(
                "Padaria LTDA",
                "38894678000138",
                "jose@email.com",
                TipoDeCliente.PESSOA_JURIDICA,
                new ArrayList<Conta>());
        bancoDeDados.addCliente(clientePj);

        ContaCorrente contaCorrentePf = new ContaCorrente(
                "00011",
                "1",
                1000,
                clientePf);
        bancoDeDados.addConta(contaCorrentePf);
        clientePf.getContasDoCliente().add(contaCorrentePf);

        ContaPoupanca contaPoupancaPf = new ContaPoupanca(
                "00012",
                "1",
                1000,
                clientePf);
        bancoDeDados.addConta(contaPoupancaPf);
        clientePf.getContasDoCliente().add(contaPoupancaPf);

        ContaInvestimento contaInvestimentoPf = new ContaInvestimento(
                "00013",
                "1",
                1000,
                clientePf);
        bancoDeDados.addConta(contaInvestimentoPf);
        clientePf.getContasDoCliente().add(contaInvestimentoPf);

        ContaCorrente contaCorrentePj = new ContaCorrente(
                "00021",
                "2",
                10000,
                clientePj);
        bancoDeDados.addConta(contaCorrentePj);
        clientePj.getContasDoCliente().add(contaCorrentePj);

        ContaInvestimento contaInvestimentoPj = new ContaInvestimento(
                "00022",
                "2",
                10000,
                clientePj);
        bancoDeDados.addConta(contaInvestimentoPj);
        clientePj.getContasDoCliente().add(contaInvestimentoPj);
    }
}


package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.*;

import java.util.ArrayList;

public class CriarContasClientesService {

    private BancoDeDados bancoDeDados;

    public CriarContasClientesService(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }
    public void CriarContasClientes(){

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

        ContaPoupanca contaPoupancaPf = new ContaPoupanca(
                "00012",
                "1",
                1000,
                clientePf);
        bancoDeDados.addConta(contaPoupancaPf);

        ContaInvestimento contaInvestimentoPf = new ContaInvestimento(
                "00013",
                "1",
                1000,
                clientePf);
        bancoDeDados.addConta(contaInvestimentoPf);

        ContaCorrente contaCorrentePj = new ContaCorrente(
                "00021",
                "2",
                10000,
                clientePj);
        bancoDeDados.addConta(contaCorrentePj);

        ContaInvestimento contaInvestimentoPj = new ContaInvestimento(
                "00022",
                "2",
                10000,
                clientePj);
        bancoDeDados.addConta(contaInvestimentoPj);
    }
}


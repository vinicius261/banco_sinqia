package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.*;

import java.util.ArrayList;

public class CriarContasClientesService {
    public void CriarContasClientes(){
        ArrayList<Conta> ContasDoCLiente= new ArrayList<>();
        BancoDeDados bancoDeDados;
        COn


        Cliente cliente = new Cliente(
                "Lucas",
                "38129476843",
                "lucas@email.com",
                TipoDeCliente.PESSOA_FISICA,
                ContasDoCLiente);
        BancoDeDados.addCliente(cliente);

        ContaCorrente contaCorrente = new ContaCorrente(
                "1",
                "1",
                100,
                cliente);
        BancoDeDados.addConta(contaCorrente);

        ContaPoupanca contaPoupanca = new ContaPoupanca(
                "2",
                "2",
                50,
                cliente
        );
        BancoDeDados.addConta(contaPoupanca);

        ContaInvestimento contaInvestimento = new ContaInvestimento(
                "3",
                "3",
                1000,
                cliente
        );
        BancoDeDados.addConta(contaInvestimento);

        BancoDeDados.setContaLogada(contaPoupanca);
    }
}


package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.*;

import java.util.ArrayList;

public class CriarContasClientesService {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public CriarContasClientesService(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }
    public void CriarContasClientes(){
        ArrayList<Conta> ContasDoCLiente= new ArrayList<>();



        Cliente cliente = new Cliente(
                "Lucas",
                "38129476843",
                "lucas@email.com",
                TipoDeCliente.PESSOA_FISICA,
                ContasDoCLiente);
        bancoDeDados.addCliente(cliente);

        ContaCorrente contaCorrente = new ContaCorrente(
                "1",
                "1",
                100,
                cliente);
        bancoDeDados.addConta(contaCorrente);

        ContaPoupanca contaPoupanca = new ContaPoupanca(
                "2",
                "2",
                50,
                cliente);
        bancoDeDados.addConta(contaPoupanca);

        ContaInvestimento contaInvestimento = new ContaInvestimento(
                "3",
                "3",
                1000,
                cliente);
        bancoDeDados.addConta(contaInvestimento);

       /* bancoDeDados.setContaLogada(contaPoupanca);*/
    }
}


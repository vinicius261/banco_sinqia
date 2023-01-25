package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.*;

import java.util.ArrayList;

public class CriarContasClientes {
    public void CriarContasClientes(BancoDeDados bancoDeDados){
        ArrayList<Conta> ContasDoCLiente= new ArrayList<>();

        Cliente cliente = new Cliente(
                "Lucas",
                "38129476843",
                "lucas@email.com",
                TipoDeCliente.PESSOA_FISICA,
                ContasDoCLiente);
       bancoDeDados.addCliente(cliente);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(100);
        contaCorrente.setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
        contaCorrente.setNumeroConta("1");
        contaCorrente.setSenha("1");
        bancoDeDados.addConta(contaCorrente);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setCliente(cliente);
        contaPoupanca.setSaldo(50);
        contaPoupanca.setTipoDeConta(TipoDeConta.CONTA_POUPANCA);
        contaPoupanca.setNumeroConta("2");
        bancoDeDados.addConta(contaPoupanca);

        ContaInvestimento contaInvestimento = new ContaInvestimento();
        contaInvestimento.setCliente(cliente);
        contaInvestimento.setSaldo(1000);
        contaInvestimento.setTipoDeConta((TipoDeConta.CONTA_INVESTIMENTO));
        contaInvestimento.setNumeroConta("3");
        bancoDeDados.addConta(contaInvestimento);

        /*bancoDeDados.setContaLogada(contaPoupanca);*/
    }
}


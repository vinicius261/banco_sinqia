package controller;

import database.BancoDeDados;
import enums.TipoDeConta;
import model.Cliente;
import model.ContaCorrente;
import model.ContaInvestimento;
import model.ContaPoupanca;

import java.util.Random;

public class AbrirContaController {
    Random gerarNumero = new Random();

    public void abrirConta(
            String Senha,
            Cliente Cliente,
            TipoDeConta TipoDeConta
    ) {
        String numeroConta = String.valueOf(gerarNumero.nextInt(100));
        System.out.println(numeroConta);
        double saldo = 0;

        if (TipoDeConta.equals(enums.TipoDeConta.CONTA_CORRENTE)){
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setNumeroConta(numeroConta);
            contaCorrente.setSenha(Senha);
            contaCorrente.setSaldo(saldo);
            contaCorrente.setCliente(Cliente);
            contaCorrente.setTipoDeConta(TipoDeConta);
            BancoDeDados.addConta(contaCorrente);

        } else if(TipoDeConta.equals(enums.TipoDeConta.CONTA_POUPANCA)){
            ContaPoupanca contaPoupanca = new ContaPoupanca();
            contaPoupanca.setNumeroConta(numeroConta);
            contaPoupanca.setSenha(Senha);
            contaPoupanca.setSaldo(saldo);
            contaPoupanca.setCliente(Cliente);
            contaPoupanca.setTipoDeConta(TipoDeConta);
            BancoDeDados.addConta(contaPoupanca);

        } else if(TipoDeConta.equals(enums.TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.setNumeroConta(numeroConta);
            contaInvestimento.setSenha(Senha);
            contaInvestimento.setSaldo(saldo);
            contaInvestimento.setCliente(Cliente);
            contaInvestimento.setTipoDeConta(TipoDeConta);
            BancoDeDados.addConta(contaInvestimento);
        }
    }
}
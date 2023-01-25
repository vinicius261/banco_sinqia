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
            String numeroDocumento,
            String Senha,
            TipoDeConta tipoDeConta
    ) {
        String numeroConta = String.valueOf(gerarNumero.nextInt(2000-1000)+1000);
        System.out.println(numeroConta);
        double saldo = 0;

        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController();
        Cliente cliente = verificarSeClienteExisteController.procurarCliente(numeroDocumento);

        if (tipoDeConta.equals(TipoDeConta.CONTA_CORRENTE)){
            ContaCorrente contaCorrente = new ContaCorrente(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente);
            BancoDeDados.addConta(contaCorrente);

        } else if(tipoDeConta.equals(TipoDeConta.CONTA_POUPANCA)){
            ContaPoupanca contaPoupanca = new ContaPoupanca(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente);
            BancoDeDados.addConta(contaPoupanca);

        } else if(tipoDeConta.equals(TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimento contaInvestimento = new ContaInvestimento(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente);
            BancoDeDados.addConta(contaInvestimento);
        }
    }
}
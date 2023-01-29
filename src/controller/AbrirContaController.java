package controller;

import database.BancoDeDados;
import enums.TipoDeConta;
import model.*;

import java.util.Random;

public class AbrirContaController {
    Random gerarNumero = new Random();
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public AbrirContaController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void abrirConta(
            String numeroDocumento,
            String Senha,
            TipoDeConta tipoDeConta
    ) {
        String numeroConta = String.valueOf(gerarNumero.nextInt(2000 - 1000) + 1000);
        System.out.println("O numero da sua nova conta e: " + numeroConta);
        double saldo = 0;

        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController(bancoDeDados, contaLogada);
        Cliente cliente = verificarSeClienteExisteController.procurarCliente(numeroDocumento);

        if (tipoDeConta.equals(TipoDeConta.CONTA_CORRENTE)) {
            ContaCorrente contaCorrente = new ContaCorrente(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente
            );
            bancoDeDados.addConta(contaCorrente);

        } else if (tipoDeConta.equals(TipoDeConta.CONTA_POUPANCA)) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente
            );
            bancoDeDados.addConta(contaPoupanca);

        } else if (tipoDeConta.equals(TipoDeConta.CONTA_INVESTIMENTO)) {
            ContaInvestimento contaInvestimento = new ContaInvestimento(
                    numeroConta,
                    Senha,
                    saldo,
                    cliente
            );
            bancoDeDados.addConta(contaInvestimento);
        }
    }
}
package controller;

import database.BancoDeDados;
import enums.TipoDeConta;
import model.*;

import java.util.Random;

public class AbrirContaController {
    Random gerarNumero = new Random();
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public AbrirContaController(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void abrirConta(
            String numeroDocumento,
            String Senha,
            TipoDeConta TipoDeConta
    ) {
        String numeroConta = String.valueOf(gerarNumero.nextInt(100));
        System.out.println(numeroConta);
        double saldo = 0;

        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController(bancoDeDados, contaLogada);
        Cliente cliente = verificarSeClienteExisteController.procurarCliente(numeroDocumento);

        if (TipoDeConta.equals(enums.TipoDeConta.CONTA_CORRENTE)){
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setNumeroConta(numeroConta);
            contaCorrente.setSenha(Senha);
            contaCorrente.setSaldo(saldo);
            contaCorrente.setCliente(cliente);
            contaCorrente.setTipoDeConta(TipoDeConta);
            bancoDeDados.addConta(contaCorrente);

        } else if(TipoDeConta.equals(enums.TipoDeConta.CONTA_POUPANCA)){
            ContaPoupanca contaPoupanca = new ContaPoupanca();
            contaPoupanca.setNumeroConta(numeroConta);
            contaPoupanca.setSenha(Senha);
            contaPoupanca.setSaldo(saldo);
            contaPoupanca.setCliente(cliente);
            contaPoupanca.setTipoDeConta(TipoDeConta);
            bancoDeDados.addConta(contaPoupanca);

        } else if(TipoDeConta.equals(enums.TipoDeConta.CONTA_INVESTIMENTO)){
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.setNumeroConta(numeroConta);
            contaInvestimento.setSenha(Senha);
            contaInvestimento.setSaldo(saldo);
            contaInvestimento.setCliente(cliente);
            contaInvestimento.setTipoDeConta(TipoDeConta);
            bancoDeDados.addConta(contaInvestimento);
        }
    }
}
package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import exceptions.AccountNotFoundException;
import exceptions.SameAccountException;
import exceptions.ValorDaTransferenciaInvalidaException;
import model.Conta;
import exceptions.SaldoInsuficienteException;

import java.util.ArrayList;

public class TransferenciaController {
    public boolean validaSenha(Conta conta, String senhaDigitada){
        if (senhaDigitada.equals(conta.getSenha())){
            return true;
        }else {
            return false;
        }
    }

    public boolean validaValorDaTransferencia(Double valorDaTransferencia){
        if (valorDaTransferencia > 0){
            return true;
        }
        throw new ValorDaTransferenciaInvalidaException("Insira apenas números maiores que zero.");
    }

    public boolean validaSaldo(Conta conta, Double valorDaTransferencia) {
        if (conta.getSaldo() >= valorDaTransferencia) {
            return true;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para a transferência.\n Saldo atual: " + conta.getSaldo() + "\n");
        }
    }

    public void transfereValores(BancoDeDados bancoDeDados, Conta contaLogada, Conta contaFavorecida, Double valorDaTransferencia){
        if (valorDaTransferencia > 0) {
            Double saldoFavorecida = contaFavorecida.getSaldo();
            contaFavorecida.setSaldo(saldoFavorecida + valorDaTransferencia);
                InvestirController investir = new InvestirController(bancoDeDados);
                investir.tipoInvestimento(contaFavorecida, valorDaTransferencia);

            Double saldoContaLogada = contaLogada.getSaldo();
            if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia - valorDaTransferencia*0.005);
            }else{
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);
            }
        }
    }

    public Conta buscaContas(String numeroDaConta, ArrayList<Conta> contas, Conta contaLogada) {

        for (Conta conta: contas) {
            if (conta.getNumeroConta().equals(numeroDaConta)
                    && (!conta.getNumeroConta().equals(contaLogada.getNumeroConta()))){
                return conta;
            }else if (numeroDaConta.equals(contaLogada.getNumeroConta())){
                throw new SameAccountException("Este é o número de sua conta, insira outro número.");
            }
        }
        throw new AccountNotFoundException("Essa conta não existe.");
    }

    public boolean confirmaAcao(String input) {
        Integer resposta = 2;

        try {
            resposta = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        if (resposta == 1) {
            return true;
        } else {
            return false;
        }
    }
}
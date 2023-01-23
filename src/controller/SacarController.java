package controller;

import exceptions.SaldoInsuficienteException;
import model.Conta;

public class SacarController {

    public boolean validaSenha(Conta conta, String senhaDigitada){
        if (senhaDigitada.equals(conta.getSenha())){ //criar getSenha nas contas
            return true;
        }else {
            return false;
        }
    }

    public boolean validaValorDoSaque(Integer valorDoSaque){
        if (valorDoSaque < 0){
            return false;
        }
        return true;
    }

    public boolean validaSaldo(Conta conta, Integer valorDoSaque) {
        if (conta.getSaldo() >= valorDoSaque) {
            return true;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque.\n Saldo atual: " + conta.getSaldo() + "\n");
        }
    }

    public void debitaValor(Conta conta, Integer valorDoSaque){
        if (valorDoSaque > 0) {
            Double saldo = conta.getSaldo();
            conta.setSaldo(saldo - valorDoSaque);
        }
    }
}

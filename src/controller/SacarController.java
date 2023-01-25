package controller;

import database.BancoDeDados;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

public class SacarController {
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public SacarController(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public boolean validaSenha(String senhaDigitada){
        if (senhaDigitada.equals(contaLogada.getSenha())){
            return true;
        }else {
            return false;
        }
    }

    public boolean validaValorDoSaque(Integer valorDoSaque){
        if (valorDoSaque < 0){
            throw new ValorDoSaqueInvalidoException("Digite apenas valores maiores que zero.");
        }
        return true;
    }

    public boolean validaSaldo(Integer valorDoSaque) {
        if (contaLogada.getSaldo() >= valorDoSaque) {
            return true;
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque.\n Saldo atual: " + contaLogada.getSaldo() + "\n");
        }
    }

    public void debitaValor(Conta conta, Integer valorDoSaque){
        if (valorDoSaque > 0) {
            Double saldo = conta.getSaldo();
            conta.setSaldo(saldo - valorDoSaque);
        }
    }
}

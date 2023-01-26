package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

public class SacarController {
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public SacarController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public boolean validaSenha(String senhaDigitada) {
        if (senhaDigitada.equals(contaLogada.getSenha())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validaValorDoSaque(Integer valorDoSaque) {
        if (valorDoSaque < 0) {
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

    public void debitaValor(Integer valorDoSaque) {
        if (valorDoSaque > 0) {
            Double saldo = contaLogada.getSaldo();
            if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
                contaLogada.setSaldo(saldo - valorDoSaque - valorDoSaque * 0.005);
            } else {
                contaLogada.setSaldo(saldo - valorDoSaque);
            }
        }
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

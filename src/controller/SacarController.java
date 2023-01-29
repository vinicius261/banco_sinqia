package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

public class SacarController {
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;
    private Double taxaCobrada;

    public SacarController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.taxaCobrada = 0.005;
    }

    public boolean validaSenha(String senhaDigitada) {
        if (senhaDigitada.equals(contaLogada.getSenha())) {
            return true;
        } else {
            return false;
        }
    }

    public void validaValorDoSaque(Integer valorDoSaque) {
        if (valorDoSaque <= 0) {
            throw new ValorDoSaqueInvalidoException("Digite apenas valores maiores que zero.");
        }
    }

    public void validaSaldo(Integer valorDoSaque, boolean taxacao) {
        Double taxa = 0.0;
        if (taxacao){
            taxa = valorDoSaque * taxaCobrada;
        }

        if (contaLogada.getSaldo() < (valorDoSaque + taxa)) {
            if(taxacao){
                taxa = valorDoSaque * taxaCobrada;
                throw new SaldoInsuficienteException("Saldo insuficiente para o saque.\n" +
                        " Saldo atual: " + contaLogada.getSaldo() + "\n" + "Taxa: " +valorDoSaque * taxaCobrada + "\n");
            }
            throw new SaldoInsuficienteException("Saldo insuficiente para o saque.\n Saldo atual: "
                    + contaLogada.getSaldo() + "\n");
        }
    }

    public void debitaValor(Integer valorDoSaque) {
        if (valorDoSaque > 0) {
            Double saldo = contaLogada.getSaldo();
            if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
                contaLogada.setSaldo(saldo - valorDoSaque - valorDoSaque * taxaCobrada);
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

    public Double getTaxaCobrada() {
        return taxaCobrada;
    }
}

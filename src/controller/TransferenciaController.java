package controller;

import exceptions.AccountNotFoundException;
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
        if (valorDaTransferencia < 0){
            return false;
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

    public void transfereValores(Conta contaLogada, Conta contafavorecida, Double valorDaTransferencia){
        if (valorDaTransferencia > 0) {
            Double saldoFavorecida = contafavorecida.getSaldo();
            contafavorecida.setSaldo(saldoFavorecida + valorDaTransferencia);

            Double saldoContaLogada = contaLogada.getSaldo();
            contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);
        }
    }

   public Conta buscaContas(String numeroDaConta, ArrayList<Conta> contas) {
       for (Conta conta: contas) {
           if (conta.getNumeroConta().equals(numeroDaConta));
           return conta;
       }
       throw new AccountNotFoundException();
    }
}

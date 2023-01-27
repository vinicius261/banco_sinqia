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
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;
    private Double taxaCobrada;

    public TransferenciaController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.taxaCobrada = 0.005;
    }

    public boolean validaSenha(String senhaDigitada){
        if (senhaDigitada.equals(contaLogada.getSenha())){
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

    public boolean validaSaldo(Double valorDaTransferencia, boolean taxacao) {
        Double taxa = 0.0;
        if (taxacao){
            taxa = valorDaTransferencia * taxaCobrada;
        }

        if (contaLogada.getSaldo() >= (valorDaTransferencia + taxa)) {
            return true;
        } else {
            if(taxacao){
                throw new SaldoInsuficienteException("Saldo insuficiente para a transferência.\n" +
                        " Saldo atual: " + contaLogada.getSaldo() + "\n" + "Taxa: " +valorDaTransferencia * taxaCobrada + "\n");
            }
            throw new SaldoInsuficienteException("Saldo insuficiente para a transferência.\n Saldo atual: "
                    + contaLogada.getSaldo() + "\n");
        }
    }

    public Double transfereValores(Conta contaFavorecida, Double valorDaTransferencia){
        Double rendimento = 0.0;

        if (valorDaTransferencia > 0) {
            Double saldoFavorecida = contaFavorecida.getSaldo();
            contaFavorecida.setSaldo(saldoFavorecida + valorDaTransferencia);
            InvestirController investir = new InvestirController(bancoDeDados);
            rendimento = investir.tipoInvestimento(contaFavorecida, valorDaTransferencia);

            Double saldoContaLogada = contaLogada.getSaldo();
            if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia - valorDaTransferencia*taxaCobrada);
            }else{
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);
            }
        }

        return rendimento;
    }

    public Conta buscaContas(String numeroDaConta, ArrayList<Conta> contas, Conta contaLogada) {
        for (Conta conta: contas) {
            if (conta.getNumeroConta().equals(numeroDaConta)
                    && (!conta.getNumeroConta().equals(contaLogada.getNumeroConta()))){
                return conta;
            }else if (numeroDaConta.equals(contaLogada.getNumeroConta())){
                throw new SameAccountException("Este é o número desta conta, insira outro número.");
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

    public Double getTaxaCobrada() {
        return taxaCobrada;
    }
}
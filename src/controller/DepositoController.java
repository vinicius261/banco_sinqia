package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Conta;

public class DepositoController {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public DepositoController(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public boolean verificaValor(double valorRecebido) {
        if (valorRecebido <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaConta(String numeroConta) {
        boolean verify = false;
        for (int i = 0; i < bancoDeDados.getContas().size(); i++) {
            if (bancoDeDados.getContas().get(i).getNumeroConta().equals(numeroConta)) {
                verify = true;
                break;
            }
        }
        return verify;
    }

    public int retornaPosicaoNoArray(String numeroConta) {
        int i;
        for (i = 0; i < bancoDeDados.getContas().size(); i++) {
            if (bancoDeDados.getContas().get(i).getNumeroConta().equals(numeroConta)) {
                break;
            }
        }
        return i;
    }

    public void deposita(double valor, String numeroConta) {
        for (int i = 0; i < bancoDeDados.getContas().size(); i++) {
            if (bancoDeDados.getContas().get(i).getNumeroConta().equals(numeroConta)) {
                bancoDeDados.getContas().get(i).setSaldo(bancoDeDados.getContas().get(i).getSaldo() + valor);
                break;
            }
        }
    }
}

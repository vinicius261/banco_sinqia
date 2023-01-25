package controller;

import static database.BancoDeDados.getContas;

public class DepositoController {

    public boolean verificaValor(double valorRecebido) {
        if (valorRecebido <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaConta(String numeroConta) {
        boolean verify = false;
        for (int i = 0; i < getContas().size(); i++) {
            if (getContas().get(i).getNumeroConta().equals(numeroConta)) {
                verify = true;
                break;
            }
        }
        return verify;
    }

    public int retornaPosicaoNoArray(String numeroConta) {
        int i;
        for (i = 0; i < getContas().size(); i++) {
            if (getContas().get(i).getNumeroConta().equals(numeroConta)) {
                break;
            }
        }
        return i;
    }

    public void deposita(double valor, String numeroConta) {
        for (int i = 0; i < getContas().size(); i++) {
            if (getContas().get(i).getNumeroConta().equals(numeroConta)) {
                getContas().get(i).setSaldo(getContas().get(i).getSaldo() + valor);
                break;
            }
        }
    }
}
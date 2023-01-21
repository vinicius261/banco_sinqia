package controller;

import static database.BancoDeDados.getContas;

public class DepositoController {

    public boolean verificaValor(double valorRecebido){
        if (valorRecebido <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaConta(String numeroConta){
        boolean verify = false;
        for (int i = 0; i < getContas().size(); i++) {
            if (getContas().get(i).getNumeroConta().equals(numeroConta)) {
                verify = true;
                break;
            }
        }
        return verify;
    }

}

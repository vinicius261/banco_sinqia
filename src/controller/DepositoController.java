package controller;

import static model.Banco.contas;

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
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroConta().equals(numeroConta)) {
                verify = true;
                break;
            }
        }
        return verify;
    }

    public void deposita (double valor, String numeroConta) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroConta().equals(numeroConta)) {
                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                break;
            }
        }
    }
}

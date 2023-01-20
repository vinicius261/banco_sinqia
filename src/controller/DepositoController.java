package controller;

import model.ListaDeContas;
import view.DepositoView;
import static model.ListaDeContas.contas;

public class DepositoController {

    ListaDeContas listaDeContas = new ListaDeContas();

    public boolean verificaValor(double valorRecebido){
        if (valorRecebido <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaConta(String numeroConta){
        if (contas.get(1)) {
            return true;
        } else {
            return false;
        }
    }

}

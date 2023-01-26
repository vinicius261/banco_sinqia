package controller;

import database.BancoDeDados;
import model.Conta;
import view.MenuInicialView;

import static view.LoginContaView.getClientBankAccount;

public class ValidadorExistenciaDeContaController {
    private int index = -1;
    private int verify = 1;


    public int[] verificaSeContaDigitadaFoiCadastrada(String clientBankAccount) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        clientBankAccount = getClientBankAccount();
        int[] values = new int[2];

        if (bancoDeDados.getContas() == null) {
            MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
            menuInicialView.mostrarMenuInicial();
        } else {


            for (int i = 0; i < bancoDeDados.getContas().size(); i++) {
                if (clientBankAccount.equals(bancoDeDados.getContas().get(i).getNumeroConta())) {
                    index = i;
                    verify = 2;
                    break;
                }
            }
            values[0] = index;
            values[1] = verify;
        }
        return values;
    }
}

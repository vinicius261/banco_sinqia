package controller;

import database.BancoDeDados;
import view.MenuInicialView;

public class ValidarExistenciaDeContaController {
    private int index = -1;

    /**
     * Método responsável em verificar a existência da conta digitada pelo usuário
     * @param clientBankAccount
     * @return Array contendo índice da conta e verificador (1: true ou 2: false)
     * @author Rodolfo Lisboa
     */
    public int verificaSeContaDigitadaFoiCadastrada(String clientBankAccount, BancoDeDados bancoDeDados) {

        if (bancoDeDados.getContas() == null) {
            MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
            menuInicialView.mostrarMenuInicial();
        } else {
            for (int i = 0; i < bancoDeDados.getContas().size(); i++) {
                if (clientBankAccount.equals(bancoDeDados.getContas().get(i).getNumeroConta())) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}

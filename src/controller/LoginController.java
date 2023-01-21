package controller;

import static database.BancoDeDados.getContas;

import exceptions.AccountNotFoundException;
import view.LoginContaView;

public class LoginController {

    private int i;
    private boolean verify = true;
    private LoginContaView loginContaView = new LoginContaView();

    /**
     * Método responsável por verificar a existência da conta fornecida para login
     *
     * @throws AccountNotFoundException
     * @author Rodolfo Lisboa
     */
    public void verificarEmail() throws AccountNotFoundException {

        while (verify) {
            try {
                for (i = 0; i < getContas().size(); i++) {
                    if (loginContaView.getClientBankAccount().equals(getContas().get(i).getNumeroConta())) {
                        verify = false;
                        break;
                    }
                }
            } catch (AccountNotFoundException e) {
                System.out.println(e.getMessage());
                verify = true;
            }
        }

    }

    public String logarClienteCadastrado() {


        return "a";
    }
}

package controller;

import static database.BancoDeDados.getContas;
import static view.LoginContaView.getClientBankAccount;
import static view.LoginContaView.getClientBankPassword;

import exceptions.AccountNotFoundException;
import exceptions.PasswordNotFoundException;

public class LoginController {

    private int i, count = -1;
    private boolean verify;

    /**
     * Método responsável por verificar a existência da conta fornecida para login.
     *
     * @return boolean
     * @throws AccountNotFoundException
     * @author Rodolfo Lisboa
     */
    public boolean verificaContaCadastrada(String clientBankAccount) throws AccountNotFoundException {
        verify = true;
        try {
            for (i = 0; i < getContas().size(); i++) {
                if (getClientBankAccount().equals(getContas().get(i).getNumeroConta())) {
                    verify = false;
                    count = i;
                    break;
                }
            }
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Por favor, tente novamente.");
            verify = true;
        }
        return verify;
    }

    /**
     * Método responsável por verificar se a senha informada é a correta.
     *
     * @param clientBankPassword
     * @return boolean
     * @throws PasswordNotFoundException
     * @author Rodolfo Lisboa
     */
    public boolean verificaSenhaCorreta(String clientBankPassword) throws PasswordNotFoundException {
        verify = true;
        try {
            if (getClientBankPassword().equals(getContas().get(count).getSenha())) {
                verify = false;
            }
        } catch (PasswordNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Por favor, tente novamente.");
            verify = true;
        }
        return verify;
    }

}

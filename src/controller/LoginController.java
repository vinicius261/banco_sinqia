package controller;

import exceptions.AccountNotFoundException;
import exceptions.PasswordNotFoundException;
import model.Conta;
import view.LoginContaView;
import view.MenuContaView;

import static database.BancoDeDados.getContas;
import static database.BancoDeDados.setContaLogada;
import static view.LoginContaView.getClientBankAccount;
import static view.LoginContaView.getClientBankPassword;

public class LoginController {

    private int index = -1;
    private boolean verify = true;

    // private LoginContaView loginContaView= new LoginContaView();

    /**
     * Método responsável por verificar a existência da conta fornecida para login.
     *
     * @param clientBankAccount
     * @return boolean
     * @throws AccountNotFoundException
     * @author Rodolfo Lisboa
     */
    public int verificaSeContaDigitadaFoiCadastrada(String clientBankAccount) {
        clientBankAccount = getClientBankAccount();

        for (int i = 0; i < getContas().size(); i++) {
            if (clientBankAccount.equals(getContas().get(i).getNumeroConta())) {
                verify = false;
                index = i;
                break;
            }
        }

        if (verify) {
            System.out.println("A conta informada não confere.\n");
            LoginContaView loginContaView = new LoginContaView();
            loginContaView.decidirLogarOuIrParaMenuView();
        }
        return index;
    }

    /**
     * Método responsável por verificar se a senha informada é a correta.
     *
     * @param clientBankPassword
     * @param indexConta
     * @return boolean
     * @throws PasswordNotFoundException
     * @author Rodolfo Lisboa
     */
    public void VerificaSeSenhaDigitadaConfere(String clientBankPassword, int indexConta) {
        clientBankPassword = getClientBankPassword();

        if (clientBankPassword.equals(getContas().get(indexConta).getSenha())) {
            logarNaConta(indexConta);
            MenuContaView menuContaView = new MenuContaView();
            menuContaView.mostrarMenuConta();
        } else {
            System.out.println("A senha não confere.\n");
            LoginContaView loginContaView = new LoginContaView();
            loginContaView.decidirLogarOuIrParaMenuView();
        }
    }

    /**
     * Método responsável por informar em qual o número da conta o cliente fez o login
     *
     * @return String contendo o número da conta que foi logada
     * @author Rodolfo Lisboa
     */
    public void logarNaConta(int indexConta) {
        Conta contaDigitadaAoLogar = getContas().get(indexConta);
        setContaLogada(contaDigitadaAoLogar);
    }

}

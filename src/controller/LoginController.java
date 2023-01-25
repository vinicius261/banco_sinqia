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
    public int verificaContaCadastrada(String clientBankAccount) {
        clientBankAccount = getClientBankAccount();

        for (int i = 0; i < getContas().size(); i++) {
            if (clientBankAccount.equals(getContas().get(i).getNumeroConta())) {
                verify = false;
                index = i;
                break;
            }
        }

        if (verify) {
            System.out.println("A conta informada não confere.");
            LoginContaView loginContaView = new LoginContaView();
            loginContaView.decidirLogarOuMenuView();
        }
        return index;
    }

    /**
     * Método responsável por verificar se a senha informada é a correta.
     *
     * @param clientBankPassword
     * @param indexConta
     * @param count
     * @return boolean
     * @throws PasswordNotFoundException
     * @author Rodolfo Lisboa
     */
    public void verificaSenhaCorreta(String clientBankPassword, int indexConta, int count) {
        clientBankPassword = getClientBankPassword();

       /* System.out.println("===================================");
        System.out.println("O índice da conta e da senha é:  " + indexConta);
        System.out.println("A conta digitada foi: " + getClientBankAccount());
        System.out.println("A senha digitada foi: " + getClientBankPassword());
        System.out.println("A senha cadastrada é: " + getContas().get(indexConta).getSenha());
        System.out.println("O valor do contador é: " + count);
        System.out.println("===================================");*/

        if (getClientBankPassword().equals(getContas().get(indexConta).getSenha())) {
            loginContaController(indexConta);
            MenuContaView menuContaView = new MenuContaView();
            menuContaView.mostrarMenuConta();
        } else {
            System.out.println("A senha não confere.");
            LoginContaView loginContaView = new LoginContaView();
            loginContaView.decidirLogarOuMenuView();

        }
    }

    /**
     * Método responsável por informar em qual o número da conta o cliente fez o login
     *
     * @return String contendo o número da conta que foi logada
     * @author Rodolfo Lisboa
     */
    public void loginContaController(int indexConta) {
        Conta contaDigitadaAoLogar = getContas().get(indexConta);
        setContaLogada(contaDigitadaAoLogar);
    }

}

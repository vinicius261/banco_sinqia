package controller;

import database.BancoDeDados;
import exceptions.AccountNotFoundException;
import exceptions.PasswordNotFoundException;
import model.Conta;
import service.ContaLogadaService;
import view.LoginContaView;
import view.MenuContaView;

import static view.LoginContaView.getClientBankAccount;
import static view.LoginContaView.getClientBankPassword;

public class LoginController {

    private int index = -1;
    private boolean verify = true;

    // private LoginContaView loginContaView= new LoginContaView();

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public LoginController(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

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

        ValidadorExistenciaDeContaController validador = new ValidadorExistenciaDeContaController();
        int[] values = validador.verificaSeContaDigitadaFoiCadastrada(clientBankAccount);

        index = values[0];

        if (values[1] == 1) {
            verify = true;
        } else {
            verify = false;
        }

        if (verify) {
            System.out.println("A conta informada não confere.\n");
            LoginContaView loginContaView = new LoginContaView(bancoDeDados);
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

        if (clientBankPassword.equals(bancoDeDados.getContas().get(indexConta).getSenha())) {
            contaLogada = logarNaConta(indexConta);
            MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
            menuContaView.mostrarMenuConta();
        } else {
            System.out.println("A senha não confere.\n");
            LoginContaView loginContaView = new LoginContaView(bancoDeDados);
            loginContaView.decidirLogarOuIrParaMenuView();
        }
    }

    /**
     * Método responsável por informar em qual o número da conta o cliente fez o login
     *
     * @return String contendo o número da conta que foi logada
     * @author Rodolfo Lisboa
     */
    public Conta logarNaConta(int indexConta) {
        Conta contaDigitadaAoLogar = bancoDeDados.getContas().get(indexConta);
        ContaLogadaService service = new ContaLogadaService(contaDigitadaAoLogar);
        return service.getContaLogada();
    }

}

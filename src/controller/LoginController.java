package controller;

import database.BancoDeDados;
import exceptions.AccountNotFoundException;
import exceptions.PasswordNotFoundException;
import model.Conta;
import service.ContaLogadaService;
import view.LoginContaView;
import view.MenuContaView;

public class LoginController {

    private int index = -1;
    private boolean verify = true;

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public LoginController(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    /**
     * Método responsável em processar a não existência da conta digitada ao logar.
     * @param clientBankAccount
     * @return índice relacionado à conta cadastrada.
     * @throws AccountNotFoundException
     */
    public int verificaSeContaDigitadaFoiCadastrada(String clientBankAccount, BancoDeDados bancoDeDados) {

        ValidarExistenciaDeContaController validador = new ValidarExistenciaDeContaController();
        index = validador.verificaSeContaDigitadaFoiCadastrada(clientBankAccount, bancoDeDados);

        if (index == -1) {
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
     */
    public void VerificaSeSenhaDigitadaConfere(String clientBankPassword, int indexConta) {

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
     * @return String contendo o número da conta que foi logada
     */
    public Conta logarNaConta(int indexConta) {
        Conta contaDigitadaAoLogar = bancoDeDados.getContas().get(indexConta);
        ContaLogadaService service = new ContaLogadaService(contaDigitadaAoLogar);
        return service.getContaLogada();
    }

}

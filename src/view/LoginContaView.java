package view;

import controller.LoginController;
import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class LoginContaView {

    /*completar classe-metodo - coloquei um sout pra ver se funcionava
    seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    coloquei atributo userLogado em Banco*/


    int index = -1, option;
    private static String clientBankAccount, clientBankPassword;
    private boolean verify;
    private static Scanner entrance = new Scanner(System.in);
    private BancoDeDados bancoDeDados;

    public LoginContaView(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    public static String getClientBankAccount() {
        return clientBankAccount;
    }

    public static String getClientBankPassword() {
        return clientBankPassword;
    }

    /**
     * Método para receber o número da conta em que o Cliente quer logar e direcioná-la para averiguação.
     *
     * @author Rodolfo Lisboa
     */
    public void logarContaView() {
        LoginController loginController = new LoginController(bancoDeDados);

        System.out.println("Olá, para entrar no banco, por favor digite sua conta cadastrada:");
        clientBankAccount = entrance.nextLine();

        index = loginController.verificaSeContaDigitadaFoiCadastrada(clientBankAccount);
        receberSenhaAConferirView();
    }

    /**
     * Método responsável por receber a senha digitada e direcioná-la para verificação
     *
     * @author Rodolfo Lisboa
     */
    public void receberSenhaAConferirView() {

        System.out.println("\nPor favor, agora digite sua senha:");

        clientBankPassword = entrance.nextLine();

        LoginController loginController = new LoginController(bancoDeDados);
        loginController.VerificaSeSenhaDigitadaConfere(clientBankPassword, index);
    }

    /**
     * Método responsável por oferecer opção de voltar para cadastrar conta ou tentar logar novamente
     *
     * @outhor Rodolfo Lisboa
     */
    public void decidirLogarOuIrParaMenuView() {
        verify = true;
        do {
            System.out.println("\n------------------------------------------------------------");
            System.out.println("O que deseja fazer? Digite uma das seguintes opções:" + "\n1 - TENTAR LOGAR NOVAMENTE" + "\n2 - VOLTAR AO MENU INICIAL");
            option = Integer.parseInt(entrance.nextLine());
            switch (option) {
                case 1:
                    logarContaView();
                    verify = false;
                    break;
                case 2:
                    MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
                    menuInicialView.mostrarMenuInicial();
                    verify = false;
                    break;
                default:
                    System.out.println("Digito inválido, tente novamente:");
            }
        } while (verify);

    }
}

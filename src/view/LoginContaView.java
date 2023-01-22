package view;

import controller.LoginController;

import java.util.Scanner;

public class LoginContaView {

    /*completar classe-metodo - coloquei um sout pra ver se funcionava
    seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    coloquei atributo userLogado em Banco*/


    int i, index = -1, count = 0, option;
    private static String clientBankAccount, clientBankPassword;
    private boolean verify;
    private static Scanner entrance = new Scanner(System.in);

    public static String getClientBankAccount() {
        return clientBankAccount;
    }

    public static String getClientBankPassword() {
        return clientBankPassword;
    }

    /**
     * Método responsável por iniciar o login na conta do cliente.
     *
     * @author Rodolfo Lisboa
     */
    public void logarContaView() {
        LoginController loginController = new LoginController();

        System.out.println("Olá, para entrar no banco, por favor digite sua conta cadastrada:");
        clientBankAccount = entrance.nextLine();

        index = loginController.verificaContaCadastrada(clientBankAccount);
        receberSenhaAConferirView();
    }

    /**
     * Método responsável por receber a senha digitada e testá-la pela primeira vez
     *
     * @author Rodolfo Lisboa
     */
    public void receberSenhaAConferirView() {

        System.out.println("Por favor, agora digite sua senha:");

        clientBankPassword = entrance.nextLine();

        LoginController loginController = new LoginController();
        loginController.verificaSenhaCorreta(clientBankPassword, index, count);
    }

    /**
     * Método responsável por oferecer opção de voltar para cadastrar conta ou tentar logar novamente
     *
     * @outhor Rodolfo Lisboa
     */
    public void decidirLogarOuMenuView() {
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
                    MenuInicialView menuInicialView = new MenuInicialView();
                    menuInicialView.mostrarMenuInicial();
                    verify = false;
                    break;
                default:
                    System.out.println("Digito inválido, tente novamente:");
            }
        } while (verify);

    }
}

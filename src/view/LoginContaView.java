package view;

import controller.LoginController;

import java.util.Scanner;

public class LoginContaView {

    //completar classe-metodo - coloquei um sout pra ver se funcionava
    //seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    //coloquei atributo userLogado em Banco

    private static String clientBankAccount, clientBankPassword;
    private boolean verify;
    private static Scanner entrance = new Scanner(System.in);
    private LoginController loginController = new LoginController();

    public static String getClientBankAccount() {
        return clientBankAccount;
    }

    public static String getClientBankPassword() {
        return clientBankPassword;
    }

    /**
     * Método responsável em logar na conta do cliente.
     * @author Rodolfo Lisboa
     */
    public void loginConta() {
        do {
            System.out.println("Olá, para entrar no banco, por favor digite sua conta cadastrada:");
            clientBankAccount = entrance.nextLine();

            loginController.verificaContaCadastrada(clientBankAccount);

        } while (verify);

        do {
            System.out.println("Por favor, agora digite sua senha:");
            clientBankPassword = entrance.nextLine();

            loginController.verificaSenhaCorreta(clientBankPassword);

        } while (verify);

        entrance.close();

        // lembretes Rodolfo:
        // bancoDeDados.setContaLogada(clientBankAccount) - view não acessa banco de dados diretamente (verificar)
        // return clientBankAccount - mudar método: void para String (verificar)

        MenuContaView menuContaView = new MenuContaView();
        menuContaView.mostrarMenuConta();
    }
}

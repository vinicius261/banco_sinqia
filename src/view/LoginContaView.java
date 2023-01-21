package view;

import java.util.Scanner;

public class LoginContaView {

    //completar classe-metodo - coloquei um sout pra ver se funcionava
    //seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    //coloquei atributo userLogado em Banco

    private String clientBankAccount, clientBankPassword;

    public static Scanner entrance = new Scanner(System.in);
    public void loginConta(){
        System.out.println("Olá, para entrar no banco, por favor digite sua conta cadastrada:");
        clientBankAccount = entrance.nextLine();


        System.out.println("Por favor, agora digite sua senha:");
        clientBankPassword = entrance.nextLine();


        MenuContaView menuContaView = new MenuContaView();
        menuContaView.mostrarMenuConta();
    }

    public String getClientBankAccount() {
        return clientBankAccount;
    }

    public String getClientBankPassword() {
        return clientBankPassword;
    }

}

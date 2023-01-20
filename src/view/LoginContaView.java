package view;

import model.ListaDeClientes;

import java.util.Scanner;

public class LoginContaView {

    //completar classe-metodo - coloquei um sout pra ver se funcionava
    //seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    //coloquei atributo userLogado em Banco

    private String clientEmail, clientPassword;

    public static Scanner entrance = new Scanner(System.in);
    public void loginConta(){
        System.out.println("Olá, para entrar no banco, por favor digite seu e-mail cadastrado:");
        clientEmail = entrance.nextLine();


        System.out.println("Por favor, agora digite sua senha:");
        clientPassword = entrance.nextLine();

        ListaDeClientes listaDeClientes = new ListaDeClientes();
        listaDeClientes.getClientes();

        MenuContaView menuContaView = new MenuContaView();
        menuContaView.mostrarMenuConta();
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientPassword() {
        return clientPassword;
    }
}

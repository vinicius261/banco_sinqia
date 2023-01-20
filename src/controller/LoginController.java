package controller;

import model.ListaDeClientes;
import view.LoginContaView;

public class LoginController {

    private int i, count = -1;
    private boolean verify = true;
    private LoginContaView loginContaView = new LoginContaView();
    private ListaDeClientes listaDeClientes = new ListaDeClientes();

    public void verificarEmail() {

        for (i = 0; i < listaDeClientes.getClientes().size(); i++) {
            if (loginContaView.getClientEmail().equals(listaDeClientes.getClientes().get(i).getEmail())) {
                count = i;
                verify = false;
                break;
            }
        }
    }

    public String logarClienteCadastrado() {

        listaDeClientes.getClientes();

        return "a";
    }
}

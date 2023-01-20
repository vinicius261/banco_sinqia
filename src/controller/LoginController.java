package controller;

import static model.Banco.clientes;

import exceptions.UserNotFoundException;
import view.LoginContaView;

public class LoginController {

    private int i, count = -1;
    private boolean verify = true;
    private LoginContaView loginContaView = new LoginContaView();

    public void verificarEmail() {

        for (i = 0; i < clientes.size(); i++) {
            if (loginContaView.getClientEmail().equals(clientes.get(i).getEmail())) {
                count = i;
                verify = false;
                break;
            }
        }


       /* if (count == -1) {
            throw new UserNotFoundException();
            } */

    }

    public String logarClienteCadastrado() {



        return "a";
    }
}

package controller;

import static model.Banco.contas;

import view.LoginContaView;

public class LoginController {

    private int i, count = -1;
    private boolean verify = true;
    private LoginContaView loginContaView = new LoginContaView();

    public void verificarEmail() {

        for (i = 0; i < contas.size(); i++) {
            if (loginContaView.getClientEmail().equals(contas.get(i).getNumeroConta())) {
                count = i;
                break;
            }
        }

        while (verify) {
            try {

            } catch ( )
        }
       /* if (count == -1) {
            throw new UserNotFoundException();
            } */

    }

    public String logarClienteCadastrado() {



        return "a";
    }
}

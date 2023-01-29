package controller;

import database.BancoDeDados;

public class BuscarEmailController {
    private BancoDeDados bancoDeDados;
    public Boolean buscaEmail(String email) {
        boolean emailExiste = false;
        for (int i = 0; i < bancoDeDados.getClientes().size(); i++) {
            if (bancoDeDados.getClientes().get(i).getEmail().equals(email)) {
                emailExiste = true;
                System.out.println("Email já cadastrado.");
            }
        }
        return emailExiste;
    }
}

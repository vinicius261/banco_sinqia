package controller;

import database.BancoDeDados;

public class BuscarEmailController {
    private BancoDeDados bancoDeDados;
    public BuscarEmailController(BancoDeDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    public Boolean buscaEmail(String email) {
        boolean emailExiste = false;
        for (int i = 0; i < this.bancoDeDados.getClientes().size(); i++) {
            if (this.bancoDeDados.getClientes().get(i).getEmail().equals(email)) {
                emailExiste = true;
                System.out.println("Email já cadastrado.");
            }
        }
        return emailExiste;
    }
}

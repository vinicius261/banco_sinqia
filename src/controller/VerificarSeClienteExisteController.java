package controller;

import database.BancoDeDados;
import database.BancoDeDados.*;
import model.Cliente;

import java.util.ArrayList;

public class VerificarSeClienteExisteController {
    public boolean verificarSeClienteExiste(String documento){
        System.out.println("VerificarSeClienteExisteController");
        boolean clienteExiste = false;
        ArrayList<Cliente> listaDeclientes;
        listaDeclientes = BancoDeDados.getClientes();
        for(Cliente cliente : listaDeclientes){
            if(cliente.getDocumento().equals(documento)){
                clienteExiste = true;
            }
        }
        return clienteExiste;
    }
}

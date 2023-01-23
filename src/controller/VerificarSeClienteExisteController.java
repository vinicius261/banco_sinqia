package controller;

import database.BancoDeDados;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class VerificarSeClienteExisteController {
    public boolean verificarSeClienteExiste(String documento){
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

    public Cliente procurarCliente(String numeroDocumento){
        List<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes = BancoDeDados.getClientes();
        Cliente clienteEncontrado = null;

        for(Cliente cliente : listaDeClientes){
            if(cliente.getDocumento().equals(numeroDocumento)){
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }
}

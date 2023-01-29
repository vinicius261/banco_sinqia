package controller;

import database.BancoDeDados;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.List;

public class VerificarSeClienteExisteController {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public VerificarSeClienteExisteController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public boolean verificarSeClienteExiste(String documento) {
        boolean clienteExiste = false;
        ArrayList<Cliente> listaDeclientes;
        listaDeclientes = bancoDeDados.getClientes();
        for (Cliente cliente : listaDeclientes) {
            if (cliente.getDocumento().equals(documento)) {
                clienteExiste = true;
            }
        }
        return clienteExiste;
    }

    public Cliente procurarCliente(String numeroDocumento) {
        List<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes = bancoDeDados.getClientes();
        Cliente clienteEncontrado = null;

        for (Cliente cliente : listaDeClientes) {
            if (cliente.getDocumento().equals(numeroDocumento)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }
}

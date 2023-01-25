package database;

import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class BancoDeDados {
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public BancoDeDados() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }


    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void addConta(Conta conta){
        this.contas.add(conta);
    }


    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}

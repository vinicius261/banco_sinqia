package database;

import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class BancoDeDados {

    private Conta contaLogada;

    private static ArrayList<Conta> contas = new ArrayList<>();

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public BancoDeDados() {
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }

    public static ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}

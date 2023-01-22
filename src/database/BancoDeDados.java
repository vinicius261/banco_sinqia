package database;

import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class BancoDeDados {

    private static Conta contaLogada;

    private static ArrayList<Conta> contas = new ArrayList<>();

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public BancoDeDados() {
    }

    public static Conta getContaLogada() {
        return contaLogada;
    }

    public static void setContaLogada(Conta contaLogada) {
        BancoDeDados.contaLogada = contaLogada;
    }

    public static ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    public static void addConta(Conta conta){
        contas.add(conta);
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
}

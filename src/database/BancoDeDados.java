package database;

import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class BancoDeDados {

    private static BancoDeDados bancoDeDados = new BancoDeDados();
    private Conta contaLogada;


    private static ArrayList<Cliente> clientes;

    private static ArrayList<Conta> contas;

    private BancoDeDados() {
        contas = new ArrayList<>();
        clientes = new ArrayList<>();
        this.contaLogada = null;
    }

    public static BancoDeDados banco() {
        return bancoDeDados;
    }

    public static Conta getContaLogada() {
        return contaLogada;
    }

    public static void setContaLogada(Conta contaLogada) {

        bancoDeDados.contaLogada = contaLogada;

    }

    public static ArrayList<Conta> getContas() {
        return bancoDeDados.contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    public static void addConta(Conta conta){
        contas.add(conta);
    }


    public static ArrayList<Cliente> getClientes() {
        return bancoDeDados.clientes;

    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }


    public static void addConta(Conta conta) {
        contas.add(conta);
    }

    public static void addCliente(Cliente cliente) {

        clientes.add(cliente);
    }
}

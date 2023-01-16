package model;

import java.util.ArrayList;

public class ListaDeClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ListaDeClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}

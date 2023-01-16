package model;

import java.util.ArrayList;

public class ListaDeContas {

    private ArrayList<Conta> contas = new ArrayList<>();

    public ListaDeContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
}

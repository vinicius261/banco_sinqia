package model;

import enums.TipoDeCliente;

import java.util.ArrayList;

public class Cliente {

    private String nome, documento, email;
    private TipoDeCliente tipoDeCliente;
    private ArrayList<Conta> contasDoCliente;

    public Cliente(String nome, String documento, String email, TipoDeCliente tipoDeCliente, ArrayList<Conta> contasDoCliente) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.tipoDeCliente = tipoDeCliente;
        this.contasDoCliente = contasDoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public ArrayList<Conta> getContasDoCliente() {
        return contasDoCliente;
    }
}



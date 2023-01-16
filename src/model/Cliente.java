package model;

import enums.TipoDeCliente;

public class Cliente {

    private String nome, documento, email, dataDeNascimento;
    private TipoDeCliente tipoDeCliente;

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }
}

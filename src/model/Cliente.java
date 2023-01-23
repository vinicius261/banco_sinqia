package model;

import enums.TipoDeCliente;

public class Cliente {

    private String nome, documento, email, dataDeNascimento;
    private TipoDeCliente tipoDeCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String nome){
        this.documento = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String nome){
        this.email = nome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDenascimento(String dataDenascimento){
        this.dataDeNascimento = nome;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(TipoDeCliente tipoDeCliente){
        this.tipoDeCliente = tipoDeCliente;
    }
}



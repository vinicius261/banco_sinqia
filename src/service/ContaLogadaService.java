package service;

import model.Conta;

public class ContaLogadaService {
    private Conta contaLogada;

    public ContaLogadaService(Conta contaLogada){
        this.contaLogada = contaLogada;
    }

    public Conta getContaLogada(){
        return this.contaLogada;
    }
}

package model;

import enums.TipoDeConta;

public class ContaCorrente extends Conta {

    private TipoDeConta tipoDeConta;

    public ContaCorrente(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        this.tipoDeConta = TipoDeConta.CONTA_CORRENTE;
    }
}

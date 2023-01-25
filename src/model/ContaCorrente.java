package model;

import enums.TipoDeConta;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numeroConta, String senha, double saldo, Cliente cliente) {
        super(numeroConta, senha, saldo, cliente);
        setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
    }
}

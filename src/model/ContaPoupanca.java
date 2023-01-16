package model;

public class ContaPoupanca extends Conta implements Investimento {

    public ContaPoupanca(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void investir() {
        /*
        if (pessoa física) {rendimento 1% no depósito}
        else if (pessoa jurídica) {não podem ter conta poupança}
        */
    }

}


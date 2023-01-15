package model;

public class ContaPoupanca extends Conta implements Investimento{

    protected ContaPoupanca(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void investir() {

    }
}

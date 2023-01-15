package model;

public class ContaInvestimento extends Conta implements Investimento{

    protected ContaInvestimento(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void investir() {

    }
}

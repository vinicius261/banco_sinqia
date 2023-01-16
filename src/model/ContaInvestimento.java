package model;

public class ContaInvestimento extends Conta implements Investimento {

    public ContaInvestimento(String numeroConta, double saldo) {
        super(numeroConta, saldo);
    }

    @Override
    public void investir() {

        /*
        if (pessoa jurídica) {rendimento de 1.5% ao depositar}
        else if (pessoa jurídica) {rendimento 3.5% ao depositar}
        */
    }
}

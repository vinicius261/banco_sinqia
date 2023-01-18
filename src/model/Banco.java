package model;

public class Banco {

    private static Conta contaLogada;

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta userLogado) {
        this.contaLogada = userLogado;
    }

}

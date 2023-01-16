package model;

public class Banco {

    private static Conta userLogado;

    public Conta getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Conta userLogado) {
        this.userLogado = userLogado;
    }

}

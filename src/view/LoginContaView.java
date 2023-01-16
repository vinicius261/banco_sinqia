package view;

public class LoginContaView {

    //completar classe-metodo - coloquei um sout pra ver se funcionava
    //seria bom settar um userlogado - para facilitar pegar as infos da Conta em outras classes/metodos
    //coloquei atributo userLogado em Banco
    public void loginConta(){
        System.out.println("logando");
        MenuContaView menuContaView = new MenuContaView();
        menuContaView.mostrarMenuConta();
    }
}

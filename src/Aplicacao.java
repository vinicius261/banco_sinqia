import model.Banco;
import model.Cliente;
import model.Conta;
import view.MenuInicialView;

public class Aplicacao {

    public static void main(String[] args) {
        System.out.println("\n===================================================================");
        System.out.println("=                       ADAS BANK                   /)-/)       =");
        System.out.println("=        Crie sua conta e faça seus investimentos  (>^.^<)      =");
        System.out.println("===================================================================");
        Banco bancoDeDados = new Banco();
        bancoDeDados.popularComDados();
        MenuInicialView menuInicialView = new MenuInicialView();
        menuInicialView.mostrarMenuInicial();


    }
    //bruna
}
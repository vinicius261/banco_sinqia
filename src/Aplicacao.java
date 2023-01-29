import database.BancoDeDados;
import database.populabanco.PopulaBancoDeDados;
import view.MenuInicialView;

public class Aplicacao {

    public static void main(String[] args) {

        BancoDeDados bancoDeDados = new BancoDeDados();

        PopulaBancoDeDados populaBancoDedados = new PopulaBancoDeDados(bancoDeDados);
        populaBancoDedados.CriarContasClientes();

        System.out.println("\n===================================================================");
        System.out.println("=                       ADAS BANK                   /)-/)       =");
        System.out.println("=     Crie sua conta e realize seus investimentos  (>^.^<)      =");
        System.out.println("===================================================================");

        MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
        menuInicialView.mostrarMenuInicial();

    }
}
import database.BancoDeDados;
import model.Cliente;
import model.Conta;
import view.MenuInicialView;
import service.CriarContasClientes;
import java.util.Arrays;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        CriarContasClientes criarContasClientes = new CriarContasClientes();
        criarContasClientes.CriarContasClientes();
        System.out.println(BancoDeDados.getContas().get(0).getSaldo());
        System.out.println(BancoDeDados.getContas().get(1).getSaldo());

        System.out.println("\n===================================================================");
        System.out.println("=                       ADAS BANK                   /)-/)       =");
        System.out.println("=        Crie sua conta e faça seus investimentos  (>^.^<)      =");
        System.out.println("===================================================================");
        MenuInicialView menuInicialView = new MenuInicialView();
        menuInicialView.mostrarMenuInicial();

    }
    //bruna
}
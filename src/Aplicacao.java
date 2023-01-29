import database.BancoDeDados;
import service.CriarContasClientesService;
import view.MenuInicialView;

public class Aplicacao {

    public static void main(String[] args) {

        BancoDeDados bancoDeDados = new BancoDeDados();

        CriarContasClientesService criarContasClientesService = new CriarContasClientesService(bancoDeDados);
        criarContasClientesService.CriarContasClientes();

        System.out.println("\n===================================================================");
        System.out.println("=                       ADAS BANK                   /)-/)       =");
        System.out.println("=     Crie sua conta e realize seus investimentos  (>^.^<)      =");
        System.out.println("===================================================================");

        MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
        menuInicialView.mostrarMenuInicial();

    }
}
import database.BancoDeDados;
import service.CriarContasClientesService;
import view.MenuInicialView;

public class Aplicacao {

    public static void main(String[] args) {

        CriarContasClientesService criarContasClientesService = new CriarContasClientesService();
        criarContasClientesService.CriarContasClientes();
        System.out.println(BancoDeDados.getContas().get(0).getSaldo());
        System.out.println(BancoDeDados.getContas().get(0).getSenha());
        System.out.println(BancoDeDados.getContas().get(0).getNumeroConta());
        System.out.println(BancoDeDados.getContas().get(1).getSaldo());


        System.out.println("\n===================================================================");
        System.out.println("=                       ADAS BANK                   /)-/)       =");
        System.out.println("=     Crie sua conta e realize seus investimentos  (>^.^<)      =");
        System.out.println("===================================================================");
        MenuInicialView menuInicialView = new MenuInicialView();
        menuInicialView.mostrarMenuInicial();

    }
}
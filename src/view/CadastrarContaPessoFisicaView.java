package view;

import controller.AbrirContaController;
import database.BancoDeDados;
import enums.TipoDeConta;
import model.Cliente;

import java.util.Scanner;

public class CadastrarContaPessoFisicaView {

    static final Scanner input = new Scanner(System.in);
    public void cadastrarContaPessoFisica(){
        TipoDeConta tipoDeConta = null;
        System.out.println("Cadastrando conta de pessoa fisica");
        System.out.println("Deseja abrir uma conta:" +
                "\n1 - CORRENTE" +
                "\n2 - POUPANCA" +
                "\n3 - INVESTIMENTO");
        try {
            int tipoDeconta = Integer.parseInt(input.nextLine());
            if (tipoDeconta == 1 || tipoDeconta == 2 || tipoDeconta == 3) {

                switch (tipoDeconta) {
                    case 1:
                        System.out.println("-----------------------------------------------------");
                        tipoDeConta = TipoDeConta.CONTA_CORRENTE;
                        break;

                    case 2:
                        System.out.println("-----------------------------------------------------");
                        tipoDeConta = TipoDeConta.CONTA_POUPANCA;
                        break;
                    case 3:
                        System.out.println("-----------------------------------------------------");
                        tipoDeConta = TipoDeConta.CONTA_INVESTIMENTO;
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        cadastrarContaPessoFisica();
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                cadastrarContaPessoFisica();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
            cadastrarContaPessoFisica();
        }

        System.out.println("Digite uma senha para sua conta");
        String senha = input.nextLine();

        Cliente cliente = BancoDeDados.getClientes().get(0);

        AbrirContaController abrirContaController = new AbrirContaController();
        abrirContaController.abrirConta(senha, cliente, tipoDeConta);

        MenuInicialView menuInicialView = new MenuInicialView();
        menuInicialView.mostrarMenuInicial();

    }
}

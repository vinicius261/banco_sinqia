package view;

import controller.AbrirContaController;
import controller.ValidarSenhaController;
import database.BancoDeDados;
import enums.TipoDeConta;
import model.Cliente;

import java.util.Scanner;

public class CadastrarContaPessoFisicaView {

    static final Scanner input = new Scanner(System.in);
    public void cadastrarContaPessoFisica(){
        TipoDeConta tipoDeConta = null;
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

        System.out.println("Digite uma senha para sua conta" +
                "\nA senha deve conte pelo menos:" +
                        "\n8 caracteres" +
                        "\n1 letra maiuscula" +
                        "\n1 letra minuscula");
        String senha = input.nextLine();
        ValidarSenhaController validarSenhaController = new ValidarSenhaController();

        if(!validarSenhaController.validarSenha(senha)){
            System.out.println("Digite uma senha valida");
            cadastrarContaPessoFisica();
        }

        Cliente cliente = BancoDeDados.getClientes().get(0);

        AbrirContaController abrirContaController = new AbrirContaController();
        abrirContaController.abrirConta(senha, cliente, tipoDeConta);

        MenuInicialView menuInicialView = new MenuInicialView();
        menuInicialView.mostrarMenuInicial();

    }
}

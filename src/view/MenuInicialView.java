package view;

import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class MenuInicialView {
    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public MenuInicialView(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public void mostrarMenuInicial() {
        System.out.println("""
                        
                -------------------------- MENU INICIAL ---------------------------
                Digite a opcao desejada:
                1 - ABRIR CONTA
                2 - LOGAR
                3 - DEPOSITO
                0 - SAIR""");
        try {
            int escolha = Integer.parseInt(input.nextLine());
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0) {
                switch (escolha) {
                    case 1:
                        System.out.println("\n" +
                                "-------------------------- ABRIR CONTA ---------------------------");
                        AbrirContaView abrirContaView = new AbrirContaView(bancoDeDados, contaLogada);
                        abrirContaView.abrirConta();

                        mostrarMenuInicial();
                        break;

                    case 2:
                        System.out.println("\n" +
                                "-------------------------- LOGIN ---------------------------");

                        LoginContaView loginContaView = new LoginContaView(bancoDeDados);

                        loginContaView.logarContaView();
                        break;

                    case 3:
                        System.out.println("\n" +
                                "-------------------------- DEPOSITO ---------------------------");
                        DepositoView depositoView = new DepositoView(bancoDeDados, contaLogada);
                        depositoView.depositoDeslogadoView();
                        break;

                    case 0:
                        System.out.println("\n" +
                                "Banco fechado. Volte Sempre!");
                        break;

                    default:
                        System.out.println("\n" +
                                "Opcao invalida. Tente novamente.");
                        mostrarMenuInicial();
                }
            } else {
                System.out.println("\n" +
                        "Opcao invalida. Tente novamente.");
                mostrarMenuInicial();
            }
        } catch (NumberFormatException e) {
            System.out.println("\n" +
                    "Por favor, digite um numero.");
            mostrarMenuInicial();
        }
    }
}

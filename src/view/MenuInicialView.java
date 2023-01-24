package view;

import java.util.Scanner;

public class MenuInicialView {
    static final Scanner input = new Scanner(System.in);

    public void mostrarMenuInicial() {
        System.out.println("-------------------------- MENU INICIAL ---------------------------");
        System.out.println("Digite a opcao desejada: " +
                "\n1 - ABRIR CONTA " +
                "\n2 - LOGAR" +
                "\n3 - DEPOSITO" +
                "\n4 - SAIR");
        try {
            int escolha = Integer.parseInt(input.nextLine());
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4) {
                int opcao = escolha;
                switch (opcao) {
                    case 1:
                        System.out.println("-------------------------- ABRIR CONTA ---------------------------");
                        AbrirContaView abrirContaView = new AbrirContaView();
                        abrirContaView.abrirConta();

                        mostrarMenuInicial();
                        break;

                    case 2:
                        System.out.println("-------------------------- LOGIN ---------------------------");
//                        ConsultarSaldoContaAtualView consultarSaldoContaAtualView = new ConsultarSaldoContaAtualView();
//                        consultarSaldoContaAtualView.SaldoContaAtual();

                        LoginContaView loginContaView = new LoginContaView();
                        loginContaView.logarContaView();
                        break;

                    case 3:
                        System.out.println("-------------------------- DEPOSITO ---------------------------");
                        DepositoView depositoView = new DepositoView();
                        depositoView.depositoDeslogadoView();
                        break;

                    case 4:
                        System.out.println("Banco fechado. Volte Sempre!");
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        mostrarMenuInicial();
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                mostrarMenuInicial();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
            mostrarMenuInicial();
        }
    }
}

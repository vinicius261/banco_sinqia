package view;

import database.BancoDeDados;

import java.util.Scanner;

import static database.BancoDeDados.banco;
import static database.BancoDeDados.getContaLogada;

public class MenuContaView {
    static final Scanner input = new Scanner(System.in);

    public void mostrarMenuConta() {
        System.out.println("-------------------------- MENU CONTA ---------------------------");
        System.out.println("Digite a opcao desejada: " +
                "\n1 - SACAR " +
                "\n2 - SALDO" +
                "\n3 - TRANSFERIR" +
                "\n4 - INVESTIR" +
                "\n5 - DEPOSITAR" +
                "\n6 - SAIR");
        try {
            int escolha = Integer.parseInt(input.nextLine());
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5 || escolha == 6) {
                int opcao = escolha;
                switch (opcao) {
                    case 1:
                        System.out.println("-------------------------- SACAR ---------------------------");
                        SacarView sacarView = new SacarView(BancoDeDados.getContaLogada());
                        sacarView.sacar();
                        break;

                    case 2:
                        System.out.println("-------------------------- SALDO ---------------------------");
                        ConsultarSaldoContaAtualView consultarSaldoContaAtualView = new ConsultarSaldoContaAtualView();
                        consultarSaldoContaAtualView.SaldoContaAtual();
                        break;
                    case 3:
                        System.out.println("-------------------------- TRANSFERIR ---------------------------");
                        TransferenciaView transferenciaView = new TransferenciaView(BancoDeDados.getContaLogada());
                        transferenciaView.transferir();
                        break;
                    case 4:
                        System.out.println("-------------------------- INVESTIR ---------------------------");
                        InvestirView investirView = new InvestirView();
                        investirView.investirView();
                        break;
                    case 5:
                        System.out.println("-------------------------- DEPOSITAR ---------------------------");
                        DepositoView depositoView = new DepositoView();
                        depositoView.depositoView();
                        break;
                    case 6:
                        System.out.println("Banco fechado. Volte Sempre!");
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        mostrarMenuConta();
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                mostrarMenuConta();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
            mostrarMenuConta();
        }
    }
}

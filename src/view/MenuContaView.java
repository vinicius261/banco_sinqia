package view;

import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class MenuContaView {
    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public MenuContaView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void mostrarMenuConta() {
        System.out.println("-------------------------- MENU CONTA ---------------------------");
        System.out.println("Digite a opcao desejada: " +
                "\n1 - SACAR " +
                "\n2 - SALDO" +
                "\n3 - TRANSFERIR" +
                "\n4 - INVESTIR" +
                "\n5 - DEPOSITAR" +
                "\n0 - SAIR");
        try {
            int escolha = Integer.parseInt(input.nextLine());
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5 || escolha == 0) {
                int opcao = escolha;
                switch (opcao) {
                    case 1:
                        System.out.println("-------------------------- SACAR ---------------------------");
                        SacarView sacarView = new SacarView(bancoDeDados, contaLogada);
                        sacarView.sacar();
                        break;

                    case 2:
                        System.out.println("-------------------------- SALDO ---------------------------");
                        ConsultarSaldoContaAtualView consultarSaldoContaAtualView = new ConsultarSaldoContaAtualView(bancoDeDados, contaLogada);
                        consultarSaldoContaAtualView.SaldoContaAtual();
                        break;
                    case 3:
                        System.out.println("-------------------------- TRANSFERIR ---------------------------");
                        TransferenciaView transferenciaView = new TransferenciaView(bancoDeDados, contaLogada);
                        transferenciaView.transferir();
                        break;
                    case 4:
                        System.out.println("-------------------------- INVESTIR ---------------------------");
                        InvestirView investirView = new InvestirView(bancoDeDados, contaLogada);
                        investirView.investirView();
                        break;
                    case 5:
                        System.out.println("-------------------------- DEPOSITAR ---------------------------");
                        DepositoView depositoView = new DepositoView(bancoDeDados, contaLogada);
                        depositoView.depositoLogadoView();
                        break;
                    case 0:
                        MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
                        menuInicialView.mostrarMenuInicial();

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

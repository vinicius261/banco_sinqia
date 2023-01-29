package view;

import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class MenuContaView {
    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public MenuContaView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void mostrarMenuConta() {
        System.out.println("""
                        
                -------------------------- MENU CONTA ---------------------------
                Digite a opcao desejada:
                1 - SACAR
                2 - SALDO
                3 - TRANSFERIR
                4 - DEPOSITAR
                0 - SAIR""");
        try {
            int escolha = Integer.parseInt(input.nextLine());
            if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5 || escolha == 0) {
                switch (escolha) {
                    case 1:
                        System.out.println("\n" +
                                "-------------------------- SACAR ---------------------------");
                        SacarView sacarView = new SacarView(bancoDeDados, contaLogada);
                        sacarView.sacar();
                        break;

                    case 2:
                        System.out.println("\n" +
                                "-------------------------- SALDO ---------------------------");
                        ConsultarSaldoContaAtualView consultarSaldoContaAtualView = new ConsultarSaldoContaAtualView(bancoDeDados, contaLogada);
                        consultarSaldoContaAtualView.SaldoContaAtual();
                        break;
                    case 3:
                        System.out.println("\n" +
                                "-------------------------- TRANSFERIR ---------------------------");
                        TransferenciaView transferenciaView = new TransferenciaView(bancoDeDados, contaLogada);
                        transferenciaView.transferir();
                        break;
                    case 4:
                        System.out.println("\n" +
                                "-------------------------- DEPOSITAR ---------------------------");
                        DepositoView depositoView = new DepositoView(bancoDeDados, contaLogada);
                        depositoView.depositoLogadoView();
                        break;
                    case 0:
                        MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
                        menuInicialView.mostrarMenuInicial();

                    default:
                        System.out.println("\n" +
                                "Opcao invalida. Tente novamente.");
                        mostrarMenuConta();
                }
            } else {
                System.out.println("\n" +
                        "Opcao invalida. Tente novamente.");
                mostrarMenuConta();
            }
        } catch (NumberFormatException e) {
            System.out.println("\n" +
                    "Por favor, digite um numero.");
            mostrarMenuConta();
        }
    }
}

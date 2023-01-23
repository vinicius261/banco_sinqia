package view;

import controller.DepositoController;

import java.util.InputMismatchException;
import java.util.Scanner;

import static database.BancoDeDados.getContas;

public class DepositoView {
    static final Scanner scan = new Scanner(System.in);
    DepositoController depositoController = new DepositoController();
    MenuInicialView menuInicialView = new MenuInicialView();

    public void depositoView() {
        System.out.println("Bem vindo a area de depósito. Digite 1 para fazer um depósito ou digite 0 para voltar ao menu anterior.");
        String opcao = scan.next();
        if (opcao.equals("1")) {
            valorDeposito();
        } else if (opcao.equals("0")) {
            menuInicialView.mostrarMenuInicial();
        } else {
            depositoView();
        }
    }

    private double valorRecebido;
    private double valorDeposito;

    public void valorDeposito() {

        System.out.println("Por favor, digite o valor que gostaria de depositar ou digite 0 para retornar ao menu anterior.");

        try {
            valorRecebido = scan.nextDouble();
        } catch (InputMismatchException exception) {
            scan.next();
            valorDeposito();
        }

        boolean verificaValor = depositoController.verificaValor(valorRecebido);
        if (valorRecebido == 0) {
            depositoView();
        } else {
            if (verificaValor) {
                valorDeposito = valorRecebido;
                contaDeposito();
            } else {
                System.out.println("Necessario depositar um valor maior que zero.");
                valorDeposito();
            }
        }

    }

    public void contaDeposito() {
        System.out.println("Por favor, digite o número da conta ou digite 0 para retornar ao menu anterior.");
        String numeroConta = scan.next();
        boolean verificaConta = depositoController.verificaConta(numeroConta);
        if (numeroConta.equals("0")) {
            valorDeposito();
        } else {
            if (verificaConta) {
                System.out.println("Gostaria de depositar R$" + valorDeposito + " na conta nº " + numeroConta + "?");
                System.out.println("Digite 1 para confirmar ou digite 0 para cancelar e retornar ao menu anterior");
                String opcao = scan.next();
                if (opcao.equals("1")) {
                    depositoController.deposita(valorDeposito, numeroConta);
                    System.out.println("R$ " + valorDeposito + " depositado na conta " + numeroConta);
                    menuInicialView.mostrarMenuInicial();
                } else {
                    contaDeposito();
                }
            } else {
                System.out.println("Conta não existente");
                contaDeposito();
            }
        }
    }
}

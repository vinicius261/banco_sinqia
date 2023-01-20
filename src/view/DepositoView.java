package view;

import controller.DepositoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DepositoView {
    static final Scanner scan = new Scanner(System.in);
    DepositoController depositoController = new DepositoController();
    public void depositoView() {

        System.out.println("Bem vindo a area de depósito!");
        valorDeposito();
        contaDeposito();
        System.out.println("R$ " + valorDeposito + " depositado na conta " + numeroConta);
    }

    private double valorRecebido;
    private double valorDeposito;
    private String numeroConta;

    public void valorDeposito() {
        System.out.println("Por favor, digite o valor que gostaria de depositar: ");
        try {valorRecebido = scan.nextDouble();
        } catch (InputMismatchException exception) {
            scan.next();
        }
        boolean verificaValor = depositoController.verificaValor(valorRecebido);
        if (verificaValor) {
            valorDeposito = valorRecebido;
        } else
            System.out.println("Necessario depositar um valor maior que zero.");
            valorDeposito();
    }

    public void contaDeposito() {
        System.out.println("Por favor, digite o número da conta.");
        scan.nextLine();
        numeroConta = scan.nextLine();
        boolean verificaConta = depositoController.verificaConta(numeroConta);
        if (verificaConta) {
            System.out.println("Conta localizada com sucesso");
        } else
            System.out.println("Conta não existente");
            contaDeposito();
    }

}

package view;

import controller.DepositoController;
import model.Conta;

import java.util.InputMismatchException;
import java.util.Scanner;

import static database.BancoDeDados.getContas;

public class DepositoView {
    static final Scanner scan = new Scanner(System.in);
    DepositoController depositoController = new DepositoController();
    MenuInicialView menuInicialView = new MenuInicialView();

    public void depositoView() {
        System.out.println();
        System.out.println("Bem vindo a area de depósito. Digite 1 para fazer um depósito ou digite 0 para voltar ao menu anterior.");
        System.out.println();
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
    private String numeroConta;

    public void valorDeposito() {
        System.out.println();
        System.out.println("Por favor, digite o valor que gostaria de depositar ou digite 0 para retornar ao menu anterior.");
        System.out.println();
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
        System.out.println();
        System.out.println("Por favor, digite o número da conta ou digite 0 para retornar ao menu anterior.");
        System.out.println();
        numeroConta = scan.next();
        boolean verificaConta = depositoController.verificaConta(numeroConta);
        if (numeroConta.equals("0")) {
            valorDeposito();
        } else {
            if (verificaConta) {
                confirmaDeposito();
            } else {
                System.out.println();
                System.out.println("Conta inexistente.");
                contaDeposito();
            }
        }
    }

    public void confirmaDeposito(){
        int i = depositoController.retornaPosicaoNoArray(numeroConta);
        Conta conta = getContas().get(i);
        System.out.println();
        System.out.println("CONFIRMAÇÃO DOS DADOS DE DEPÓSITO");
        System.out.println("Tipo de conta: " + conta.getTipoDeConta());
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Nome do beneficiário: " + conta.getCliente().getNome());
        System.out.println("Valor: R$" + valorDeposito);
        System.out.println();
        System.out.println("Digite 1 para confirmar ou digite 0 para cancelar e retornar ao menu anterior");
        System.out.println();
        String opcao = scan.next();
        if (opcao.equals("1")) {
            depositoController.deposita(valorDeposito, numeroConta);
            System.out.println();
            System.out.println("Depósito efetuado com sucesso.");
            System.out.println();
            System.out.println("COMPROVANTE DE DEPÓSITO");
            System.out.println("Tipo de conta: " + conta.getTipoDeConta());
            System.out.println("Número da conta: " + conta.getNumeroConta());
            System.out.println("Nome do beneficiário: " + conta.getCliente().getNome());
            System.out.println("Valor: R$" + valorDeposito);
            System.out.println();
            menuInicialView.mostrarMenuInicial();
        } else {
            contaDeposito();
        }
    }
}
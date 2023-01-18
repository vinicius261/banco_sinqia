package br.com.bancosinqia.view;

import br.com.bancosinqia.controller.SacarController;

import java.util.Scanner;

public class SacarView {

    private Scanner scanner;
    private SacarController sacarController;

    public SacarView(){
        this.scanner = new Scanner(System.in);
        this.sacarController = new SacarController();
    }

    public void sacar(){
        System.out.println("Você esta na Área e Saque\n");

        movimentaConta(valorDoSaque());

        MenuContaView menuContaView = new MenuContaView();

        menuContaView.mostrarMenuConta();
    }

    public Integer valorDoSaque(){
        System.out.println("Digite o valor do saque: \n");

        Integer valorDoSaque = sacarController.validaInputDoSaque(scanner.nextLine());

        while (sacarController.validaValorDoSaque(valorDoSaque)){
            System.out.println("Insira apenas números maiores que zero: \n");
            valorDoSaque = sacarController.validaInputDoSaque(scanner.nextLine());
        }

        if (sacarController.validaSaldo(valorDoSaque)){
            return valorDoSaque;
        }else{
            System.out.println("Saldo insuficiente para o saque. Saldo atual: " + Banco.userLogado.getSaldo + "\n");
        }

        return valorDoSaque;
    }

    public void movimentaConta(Integer valorDoSaque){
        sacarController.movimentaConta(valorDoSaque);
        System.out.println("O saque de " + valorDoSaque + " foi realizado.");
    }
}

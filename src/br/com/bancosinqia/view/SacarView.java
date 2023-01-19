package br.com.bancosinqia.view;

import br.com.bancosinqia.controller.SacarController;

import java.util.Scanner;

public class SacarView {

    private Scanner scanner;
    private SacarController sacarController;

    private Conta conta;

    public SacarView(Conta conta){
        this.scanner = new Scanner(System.in);
        this.sacarController = new SacarController();
        this.conta = conta;
    }

    public void sacar(){
        System.out.println("Olá, " + conta.getCliente().getNome() + ". Você esta na Área e Saque\n");

        if(validaSenha()) {
            movimentaConta(true, valorDoSaque());
        }else {
            System.out.println("Senha incorreta.\n");
        }

        MenuContaView menuContaView = new MenuContaView();

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha(){
        System.out.println("Para continuar insira sua senha: ");
        return sacarController.validaSenha(conta, scanner.nextLine());
    }

    public Integer valorDoSaque(){
        System.out.println("Digite o valor do saque: \n");

        Integer valorDoSaque = sacarController.validaInputDoSaque(scanner.nextLine());

        while (sacarController.validaValorDoSaque(valorDoSaque)){
            System.out.println("Insira apenas números maiores que zero: \n");
            valorDoSaque = sacarController.validaInputDoSaque(scanner.nextLine());
        }

        if (sacarController.validaSaldo(conta, valorDoSaque)){
            return valorDoSaque;
        }else{
            System.out.println("Saldo insuficiente para o saque.\n Saldo atual: " + conta.getSaldo + "\n");
            return 0;
        }
    }

    public void movimentaConta(boolean senhaValidada, Integer valorDoSaque){
        if (sacarController.movimentaConta(conta, valorDoSaque) && senhaValidada) {
            System.out.println("O saque de " + valorDoSaque + " foi realizado.");
        }else {
            System.out.println("Infelizmente não foi possível realizar o saque.\n\nRetornando ao menu.");
        }
    }
}

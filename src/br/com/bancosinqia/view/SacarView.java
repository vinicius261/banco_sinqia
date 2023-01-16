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

    public void sacar(List<Conta> listaDeContas){
        Conta conta = contaDoSaque(List<Conta> listaDeContas);

        Double valorDoSaque = valorDoSaque(conta);




    }

    public Double valorDoSaque(Conta conta){
        System.out.println("Digite o valor do saque: ");

        Double valorDoSaque = sacarController.validaValorDoSaque(scanner.nextLine());

        if (sacarController.validaSaldo(conta, valorDoSaque)){
            while (valorDoSaque <= 0){
                System.out.println("Insira apenas números maiores que zero");
                valorDoSaque = sacarController.validaValorDoSaque(scanner.nextLine());
            }
        }else{
            System.out.println("Saldo insuficiente para o saque. Saldo atual: " + conta.getSaldo);
        }

        return valorDoSaque;
    }

    public Conta contaDoSaque(List<Conta> listaDeContas) {
        System.out.println("Digite o número da conta da qual deseja sacar: ");

        Conta contaDoSaque = sacarController.validaContaDoSaque(listaDeContas,scanner.nextLine());

        while (contaDoSaque == null){
            System.out.println("Essa conta não exite, verifique o número digitado.");
            contaDoSaque = sacarController.validaContaDoSaque(listaDeContas,scanner.nextLine());
        }

        return contaDoSaque;
    }

}

package view;

import controller.SacarController;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

import java.util.Scanner;

public class SacarView {

    private Scanner scanner;
    private SacarController sacarController;

    private Conta conta;

    public SacarView(Conta conta) {
        this.scanner = new Scanner(System.in);
        this.sacarController = new SacarController();
        this.conta = conta;
    }

    public void sacar() {
        System.out.println("Olá, " + conta.getCliente().getNome() + ". Você esta na Área e Saque\n");

        if (validaSenha()) {
            movimentaConta(valorDoSaque());
        } else {
            System.out.println("Senha incorreta.\n");
        }

        MenuContaView menuContaView = new MenuContaView();

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha() {
        System.out.println("Para continuar insira sua senha: ");
        return sacarController.validaSenha(conta, scanner.nextLine());
    }

    public Integer valorDoSaque() {
        MenuContaView menuContaView = new MenuContaView();

        System.out.println("Digite o valor do saque: \n");

        Integer valorDoSaque = 0;

        try {
            valorDoSaque = Integer.parseInt(scanner.nextLine());
            sacarController.validaValorDoSaque(valorDoSaque);

        } catch (NumberFormatException ex) {
            System.out.println("Digite apenas números.");
            valorDoSaque();

        } catch (ValorDoSaqueInvalidoException ex) {
            System.out.println(ex.getMessage());
            valorDoSaque();
        }

        try {
            if (sacarController.validaSaldo(conta, valorDoSaque)) {
                return valorDoSaque;
            }

        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        return valorDoSaque;
    }

    public void movimentaConta(Integer valorDoSaque){
        sacarController.debitaValor(conta, valorDoSaque);
        System.out.println("O saque de " + valorDoSaque + "R$ foi realizado.");
    }
}

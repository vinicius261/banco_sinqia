package view;

import controller.TransferenciaController;
import database.BancoDeDados;
import exceptions.AccountNotFoundException;
import exceptions.SaldoInsuficienteException;
import exceptions.SameAccountException;
import exceptions.ValorDaTransferenciaInvalidaException;
import model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class TransferenciaView {

    private Scanner scanner;
    private TransferenciaController transferenciaController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public TransferenciaView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.scanner = new Scanner(System.in);
        this.transferenciaController= new TransferenciaController();
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void transferir() {
        System.out.println("Olá, " + contaLogada.getCliente().getNome() + ". Você esta na Área de Transferências\n");

        if (validaSenha()) {
            movimentaConta(valorDaTransferencia(), contaFavorecida() );
        } else {
            System.out.println("Senha incorreta.\n");
        }

        MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha() {
        System.out.println("Para continuar insira sua senha: ");
        return transferenciaController.validaSenha(contaLogada, scanner.nextLine());
    }

    public Double valorDaTransferencia() {
        MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);

        System.out.println("Digite o valor da transferência: \n");

        Double valorDaTransferencia = 0.0;

        try {
            valorDaTransferencia = Double.parseDouble(scanner.nextLine());
            transferenciaController.validaValorDaTransferencia(valorDaTransferencia);

        } catch (NumberFormatException ex) {
            System.out.println("Digite apenas números.");
            valorDaTransferencia();

        } catch (ValorDaTransferenciaInvalidaException ex) {
            System.out.println(ex.getMessage());
            valorDaTransferencia();
        }

        try {
            if (transferenciaController.validaSaldo(contaLogada, valorDaTransferencia)) {
                return valorDaTransferencia;
            }

        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        return valorDaTransferencia;
    }

    public void movimentaConta(Double valorDaTransferencia, Conta contaFavorecida){
        transferenciaController.transfereValores(contaLogada, contaFavorecida, valorDaTransferencia);
        System.out.println("A transferência de " + valorDaTransferencia + "R$ para " + contaFavorecida + " foi feita.");
    }

    public Conta contaFavorecida() {
        System.out.println("Insira o número da conta que vai receber a transferência: ");
        try {
            Conta contaFavorecida = transferenciaController.buscaContas(scanner.nextLine(), bancoDeDados.getContas(), contaLogada);
            return contaFavorecida;
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
            MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
            menuContaView.mostrarMenuConta();
        }catch (SameAccountException ex){
            System.out.println(ex.getMessage());
            MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
            menuContaView.mostrarMenuConta();
        }
        return null;
    }
}

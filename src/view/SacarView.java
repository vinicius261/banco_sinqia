package view;

import controller.SacarController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

import javax.xml.transform.sax.SAXSource;
import java.sql.SQLOutput;
import java.util.Scanner;

public class SacarView {

    private Scanner scanner;
    private SacarController sacarController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public SacarView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.scanner = new Scanner(System.in);
        this.sacarController = new SacarController(bancoDeDados, contaLogada);
        this.contaLogada = contaLogada;
        this.bancoDeDados = bancoDeDados;
    }

    public void sacar() {
        System.out.println("Olá, " + contaLogada.getCliente().getNome() + ". Você esta na Área e Saque\n");

        if (validaSenha()) {
            movimentaConta(valorDoSaque());
        } else {
            System.out.println("Senha incorreta.\n");
        }

        MenuContaView menuContaView = new MenuContaView(bancoDeDados ,contaLogada);

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha() {
        System.out.println("Para continuar insira sua senha: ");
        return sacarController.validaSenha(scanner.nextLine());
    }

    public Integer valorDoSaque() {
        MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);

        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA){
            System.out.println("Esse tipo movimentação cobra taxas.\nPara realizar o saque digite 1. Para voltar ao menu digite qualquer valor.");
        }else{
            System.out.println("Para realizar o saque digite 1. Para voltar ao menu digite qualquer valor.");
        }

        if (sacarController.confirmaAcao(scanner.nextLine()) == false){
            menuContaView.mostrarMenuConta();
        }

        System.out.println("Digite o valor do saque: \n");

        Integer valorDoSaque = 0;

        try {
            Integer inputValorDoSaque = Integer.parseInt(scanner.nextLine());
            if(sacarController.validaValorDoSaque(inputValorDoSaque)){
                valorDoSaque = inputValorDoSaque;
            }

        } catch (NumberFormatException ex) {
            System.out.println("Digite apenas números.");
            valorDoSaque();

        } catch (ValorDoSaqueInvalidoException ex) {
            System.out.println(ex.getMessage());
            valorDoSaque();
        }

        try {
            if (sacarController.validaSaldo(valorDoSaque)) {
                return valorDoSaque;
            }

        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        return valorDoSaque;
    }

    public void movimentaConta(Integer valorDoSaque){
        sacarController.debitaValor(valorDoSaque);
        System.out.println("O saque de " + valorDoSaque + "R$ foi realizado.");
    }
}

package view;

import controller.SacarController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorDoSaqueInvalidoException;
import model.Conta;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SacarView {
    private Scanner scanner;
    private SacarController sacarController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;
    private MenuContaView menuContaView;

    public SacarView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.scanner = new Scanner(System.in);
        this.sacarController = new SacarController(bancoDeDados, contaLogada);
        this.contaLogada = contaLogada;
        this.bancoDeDados = bancoDeDados;
        this.menuContaView = new MenuContaView(bancoDeDados ,contaLogada);
    }

    public void sacar() {
        System.out.println("Olá, " + contaLogada.getCliente().getNome() + ". Você esta na Área e Saque\n");

        if (validaSenha()) {
            movimentaConta();
        } else {
            System.out.println("Senha incorreta.\n");
        }

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha() {
        System.out.println("Para continuar insira sua senha: ");

        return sacarController.validaSenha(scanner.nextLine());
    }

    public void movimentaConta(){
        Integer valorDoSaque = valorDoSaque();
        sacarController.debitaValor(valorDoSaque);

        imprimeComprovante(valorDoSaque);
    }

    public Integer valorDoSaque() {
        boolean taxacao = false;

        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA){
            System.out.println("Esse tipo movimentação cobra taxas.\n" +
                    "Para realizar um saque digite 1. Para voltar ao menu digite qualquer valor.");
            taxacao = true;
        }else{
            System.out.println("Para realizar um saque digite 1. Para voltar ao menu digite qualquer valor.");
        }

        if (sacarController.confirmaAcao(scanner.nextLine()) == false){
            menuContaView.mostrarMenuConta();
        }

        System.out.println("Digite o valor do saque: ");

        Integer valorDoSaque = 0;
        try {
            Integer inputValorDoSaque = Integer.parseInt(scanner.nextLine());
            sacarController.validaValorDoSaque(inputValorDoSaque);
            valorDoSaque = inputValorDoSaque;

        } catch (NumberFormatException ex) {
            System.out.println("Digite apenas números.");
            valorDoSaque = valorDoSaque();

        } catch (ValorDoSaqueInvalidoException ex) {
            System.out.println(ex.getMessage());
            valorDoSaque = valorDoSaque();
        }

        try {
            sacarController.validaSaldo(valorDoSaque , taxacao);
            return valorDoSaque;

        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        return valorDoSaque;
    }

    public void imprimeComprovante(Integer valorDoSaque){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_FISICA) {
            System.out.println("COMPROVANTE DE SAQUE\n" + "Tipo de conta: " + contaLogada.getTipoDeConta() +
                    "\nNúmero da conta: " + contaLogada.getNumeroConta() +
                    "\nValor: R$" + df.format(valorDoSaque));

        } else if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
            System.out.println("COMPROVANTE DE SAQUE\n" + "Tipo de conta: " +contaLogada.getTipoDeConta() +
                    "\nNúmero da conta: " + contaLogada.getNumeroConta() +
                    "\nValor: R$" + df.format(valorDoSaque) +
                    "\nTaxas: R$" + df.format(valorDoSaque*sacarController.getTaxaCobrada()));
        }
    }
}

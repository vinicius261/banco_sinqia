package view;

import controller.TransferenciaController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import exceptions.AccountNotFoundException;
import exceptions.SaldoInsuficienteException;
import exceptions.SameAccountException;
import exceptions.ValorDaTransferenciaInvalidaException;
import model.Conta;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TransferenciaView {
    private Scanner scanner;
    private TransferenciaController transferenciaController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;
    private  MenuContaView menuContaView;

    public TransferenciaView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.scanner = new Scanner(System.in);
        this.transferenciaController= new TransferenciaController(bancoDeDados, contaLogada);
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.menuContaView = new MenuContaView(bancoDeDados, contaLogada);
    }

    public void transferir() {
        System.out.println("Olá, " + contaLogada.getCliente().getNome() + ". Você esta na Área de Transferências\n");

        if (validaSenha()) {
                movimentaConta();
        } else {
            System.out.println("Senha incorreta.\nRetornando ao Menu.");
        }

        menuContaView.mostrarMenuConta();
    }

    public boolean validaSenha() {
        System.out.println("Para continuar insira sua senha: ");

        return transferenciaController.validaSenha(scanner.nextLine());
    }

    public void movimentaConta(){
        Double valorDaTransferencia = 0.0;
        Conta contaFavorecida = null;

        try {
            valorDaTransferencia = valorDaTransferencia();
            contaFavorecida = contaFavorecida();
        }catch (AccountNotFoundException | SameAccountException ex){
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        Double rendimento =  transferenciaController.transfereValores(contaFavorecida, valorDaTransferencia);

        if (contaFavorecida.getTipoDeConta() == TipoDeConta.CONTA_INVESTIMENTO || contaFavorecida.getTipoDeConta() == TipoDeConta.CONTA_POUPANCA){
            imprimeComprovante(valorDaTransferencia, contaFavorecida, rendimento );
        }else {
            imprimeComprovante(valorDaTransferencia, contaFavorecida);
        }
    }

    public void imprimeComprovante(Double valorDaTransferencia, Conta contaFavorecida){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_FISICA) {
            System.out.println("COMPROVANTE DE TRANSFERÊNCIA\n" + "Tipo de conta: " + contaFavorecida.getTipoDeConta() +
                    "\nNúmero da conta: " + contaFavorecida.getNumeroConta() +
                    "\nNome do beneficiário: " + contaFavorecida.getCliente().getNome() +
                    "\nValor: R$" + df.format(valorDaTransferencia));

        } else if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
            System.out.println("COMPROVANTE DE TRANSFERÊNCIA\n" + "Tipo de conta: " +contaFavorecida.getTipoDeConta() +
                    "\nNúmero da conta: " + contaFavorecida.getNumeroConta() +
                    "\nNome do beneficiário: " + contaFavorecida.getCliente().getNome() +
                    "\nValor: R$" + df.format(valorDaTransferencia) +
                    "\nTaxas: R$" + df.format(valorDaTransferencia*transferenciaController.getTaxaCobrada()));
        }
    }

    public void imprimeComprovante(Double valorDaTransferencia, Conta contaFavorecida, Double rendimento){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_FISICA) {
            System.out.println("COMPROVANTE DE TRANSFERÊNCIA\n" + "Tipo de conta: " + contaFavorecida.getTipoDeConta() +
                    "\nNúmero da conta: " + contaFavorecida.getNumeroConta() +
                    "\nNome do beneficiário: " + contaFavorecida.getCliente().getNome() +
                    "\nValor: R$" + df.format(valorDaTransferencia) +
                    "\nRendimento: R$" + df.format(rendimento));

        }else if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA) {
            System.out.println("COMPROVANTE DE TRANSFERÊNCIA\n" + "Tipo de conta: " +contaFavorecida.getTipoDeConta() +
                    "\nNúmero da conta: " + contaFavorecida.getNumeroConta() +
                    "\nNome do beneficiário: " + contaFavorecida.getCliente().getNome() +
                    "\nValor: R$" + df.format(valorDaTransferencia) +
                    "\nRendimento: R$" + df.format(rendimento) +
                    "\nTaxas: R$" + df.format(valorDaTransferencia*transferenciaController.getTaxaCobrada()));
        }
    }

    public Double valorDaTransferencia() {
        boolean taxacao = false;

        if(contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_JURIDICA){
            System.out.println("Esse tipo movimentação cobra taxas.\n Para realizar uma transferência digite 1. Para voltar ao menu digite qualquer valor.");
            taxacao = true;
        }else{
            System.out.println("Para realizar uma transferência digite 1. Para voltar ao menu digite qualquer valor.");
        }

        if (transferenciaController.confirmaAcao(scanner.nextLine()) == false){
            menuContaView.mostrarMenuConta();
        }

        System.out.println("Digite o valor da transferência: ");

        Double valorDaTransferencia = 0.0;

        try {
            Double inputDaTransferencia = Double.parseDouble(scanner.nextLine());
            if(transferenciaController.validaValorDaTransferencia(inputDaTransferencia)){
                valorDaTransferencia = inputDaTransferencia;
            }

        } catch (NumberFormatException ex) {
            System.out.println("Digite apenas números.");
            valorDaTransferencia = valorDaTransferencia();

        } catch (ValorDaTransferenciaInvalidaException ex) {
            System.out.println(ex.getMessage());
            valorDaTransferencia = valorDaTransferencia();
        }

        try {
            if (transferenciaController.validaSaldo(valorDaTransferencia, taxacao)) {
                return valorDaTransferencia;
            }

        } catch (SaldoInsuficienteException ex) {
            System.out.println(ex.getMessage());
            menuContaView.mostrarMenuConta();
        }

        return valorDaTransferencia;
    }

    public Conta contaFavorecida() {
        System.out.println("Insira o número da conta que vai receber a transferência: ");

        try {
            Conta contaFavorecida = transferenciaController.buscaContas(scanner.nextLine(), bancoDeDados.getContas(), contaLogada);
            return contaFavorecida;
        }catch (AccountNotFoundException ex){
            throw new AccountNotFoundException("Essa conta não existe.");
        }catch (SameAccountException ex){
            throw new SameAccountException("Este é o número de sua conta, insira outro número.");
        }
    }
}

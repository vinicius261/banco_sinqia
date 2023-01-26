package view;

import controller.DepositoController;
import controller.InvestirController;
import database.BancoDeDados;
import enums.TipoDeConta;
import model.Conta;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DepositoView {
    static final Scanner scan = new Scanner(System.in);
    DepositoController depositoController;
    MenuInicialView menuInicialView;
    InvestirController investirController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public DepositoView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.depositoController = new DepositoController(bancoDeDados, contaLogada);
        this.menuInicialView = new MenuInicialView(bancoDeDados);
        this.investirController = new InvestirController(bancoDeDados);
    }

    String padrao = "###,##0.00";
    DecimalFormat df = new DecimalFormat(padrao);

    public void depositoDeslogadoView() {
        System.out.println();
        System.out.println("Digite 1 para fazer um depósito.");
        System.out.println("Para voltar ao menu inicial digite 0.");
        System.out.println();
        String opcao = scan.next();
        if (opcao.equals("1")) {
            valorDeposito();
            contaDeposito();
            menuInicialView.mostrarMenuInicial();
        } else if (opcao.equals("0")) {
            menuInicialView.mostrarMenuInicial();
        } else {
            depositoDeslogadoView();
        }
    }

    public void depositoLogadoView() {
        System.out.println();
        System.out.println("Digite 1 para fazer um depósito na sua conta.");
        System.out.println("Para voltar ao menu anterior digite 0.");
        System.out.println();
        String opcao = scan.next();
        numeroConta = this.contaLogada.getNumeroConta();
        if (opcao.equals("1")) {
            valorDeposito();
            confirmaDeposito();
            MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
            menuContaView.mostrarMenuConta();
        } else if (opcao.equals("0")) {
            menuInicialView.mostrarMenuInicial();
        } else {
            depositoDeslogadoView();
        }
    }

    private double valorRecebido;
    private double valorDeposito;
    private String numeroConta;

    public void valorDeposito() {
        System.out.println();
        System.out.println("Digite o valor que gostaria de depositar.");
        System.out.println("Para voltar ao menu anterior digite 0.");
        System.out.println();
        try {
            valorRecebido = scan.nextDouble();
        } catch (InputMismatchException exception) {
            scan.next();
            valorDeposito();
        }

        boolean verificaValor = depositoController.verificaValor(valorRecebido);
        if (valorRecebido == 0) {
            depositoDeslogadoView();
        } else {
            if (verificaValor) {
                valorDeposito = valorRecebido;
            } else {
                System.out.println("Necessario depositar um valor maior que zero.");
                valorDeposito();
            }
        }

    }

    public void contaDeposito() {
        System.out.println();
        System.out.println("Digite o número da conta beneficiária.");
        System.out.println("Para voltar ao menu anterior digite 0.");
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

    public void confirmaDeposito() {
        int i = depositoController.retornaPosicaoNoArray(numeroConta);
        Conta conta = bancoDeDados.getContas().get(i);
        System.out.println();
        System.out.println("CONFIRMAÇÃO DOS DADOS DE DEPÓSITO");
        System.out.println("Tipo de conta: " + conta.getTipoDeConta());
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Nome do beneficiário: " + conta.getCliente().getNome());
        System.out.println("Valor: R$" + df.format(valorDeposito));
        System.out.println();
        System.out.println("Digite 1 para confirmar.");
        System.out.println("Para cancelar e voltar ao menu anterior digite 0.");
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
            System.out.println("Valor: R$" + df.format(valorDeposito));
            System.out.println();
            if (conta.getTipoDeConta().equals(TipoDeConta.CONTA_CORRENTE)) {
            } else {
                System.out.println("O seu depósito rendeu R$" + df.format(investirController.tipoInvestimento(conta, valorDeposito)));
                System.out.println("O rendimento já está disponível na conta.");
            }

        } else {
            contaDeposito();
        }
    }
}
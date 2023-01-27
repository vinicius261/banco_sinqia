package view;

import controller.DepositoController;
import controller.InvestirController;
import controller.ValidadorExistenciaDeContaController;
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
    MenuContaView menuContaView;
    InvestirController investirController;
    ValidadorExistenciaDeContaController validadorExistenciaDeContaController;
    private final BancoDeDados bancoDeDados;
    private final Conta contaLogada;

    public DepositoView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.depositoController = new DepositoController(bancoDeDados, contaLogada);
        this.menuInicialView = new MenuInicialView(bancoDeDados);
        this.investirController = new InvestirController(bancoDeDados);
        this.menuContaView = new MenuContaView(bancoDeDados, contaLogada);
        this.validadorExistenciaDeContaController = new ValidadorExistenciaDeContaController();
    }

    private final String padrao = "###,##0.00";
    DecimalFormat df = new DecimalFormat(padrao);

    public void depositoDeslogadoView() {
        logadoOuDeslogado = "Deslogado";
        System.out.println("""
                                
                Digite 1 para fazer um depósito.
                Para voltar ao menu inicial digite 0.""");
        String opcao = scan.next();
        if (opcao.equals("1")) {
            contaDeposito();
        } else if (opcao.equals("0")) {
            menuInicialView.mostrarMenuInicial();
        } else {
            depositoDeslogadoView();
        }
    }

    public void depositoLogadoView() {
        logadoOuDeslogado = "Logado";
        System.out.println("""
                                
                Digite 1 para fazer um depósito na sua conta.
                Para voltar ao menu da conta digite 0.""");
        String opcao = scan.next();
        numeroConta = this.contaLogada.getNumeroConta();
        if (opcao.equals("1")) {
            valorDeposito();
        } else if (opcao.equals("0")) {
            menuContaView.mostrarMenuConta();
        } else {
            depositoLogadoView();
        }
    }

    private String logadoOuDeslogado;
    private double valorRecebido;
    private double valorDeposito;
    private String numeroConta;

    private void contaDeposito() {
        System.out.println("""
                                
                Digite o número da conta beneficiária.
                Para voltar ao menu anterior digite 0.""");
        numeroConta = scan.next();
        int verificaConta = validadorExistenciaDeContaController.verificaSeContaDigitadaFoiCadastrada(numeroConta, bancoDeDados);
        if (numeroConta.equals("0")) {
            depositoDeslogadoView();
        } else {
            if (verificaConta == -1) {
                System.out.println("""
                                                
                        Conta inexistente.""");
                contaDeposito();
            } else {
                valorDeposito();
            }
        }
    }

    private void valorDeposito() {
        System.out.println();
        System.out.println("""
                Digite o valor que gostaria de depositar.
                Para voltar ao menu anterior digite 0.""");
        try {
            valorRecebido = scan.nextDouble();
        } catch (InputMismatchException exception) {
            scan.next();
            valorDeposito();
        }
        boolean verificaValor = depositoController.verificaValor(valorRecebido);
        if (valorRecebido == 0) {
            if (logadoOuDeslogado.equals("Deslogado")) {
                contaDeposito();
            } else {
                depositoLogadoView();
            }
        } else {
            if (verificaValor) {
                valorDeposito = valorRecebido;
                confirmaDeposito();
            } else {
                System.out.println("Necessario depositar um valor maior que zero.");
                valorDeposito();
            }
        }
    }

    private String getDadosDoDeposito() {
        int i = depositoController.retornaPosicaoNoArray(numeroConta);
        Conta conta = bancoDeDados.getContas().get(i);
        return "Tipo de conta: " + conta.getTipoDeConta() +
                "\nNúmero da conta: " + conta.getNumeroConta() +
                "\nNome do beneficiário: " + conta.getCliente().getNome() +
                "\nValor: R$" + df.format(valorDeposito);
    }

    private void confirmaDeposito() {
        int i = depositoController.retornaPosicaoNoArray(numeroConta);
        Conta conta = bancoDeDados.getContas().get(i);
        System.out.println("\n" +
                "CONFIRMAÇÃO DOS DADOS DE DEPÓSITO");
        System.out.println(getDadosDoDeposito());
        System.out.println("\n" +
                "Digite 1 para confirmar." +
                "\nPara cancelar e voltar ao menu anterior digite 0.");
        String opcao = scan.next();
        if (opcao.equals("1")) {
            depositoController.deposita(valorDeposito, numeroConta);
            System.out.println("""
                                        
                    Depósito efetuado com sucesso.

                    COMPROVANTE DE DEPÓSITO""");
            System.out.println(getDadosDoDeposito());
            if (conta.getTipoDeConta().equals(TipoDeConta.CONTA_CORRENTE)) {
            } else {
                System.out.println("\n"+
                        "O seu depósito rendeu R$" + df.format(investirController.tipoInvestimento(conta, valorDeposito)) +
                        "\nO rendimento já está disponível na conta.");
            }
            if (logadoOuDeslogado.equals("Deslogado")) {
                menuInicialView.mostrarMenuInicial();
            } else {
                menuContaView.mostrarMenuConta();
            }
        } else {
            valorDeposito();
        }
    }
}
package view;

import controller.AbrirContaController;
import controller.ValidarCpfCnpj;
import controller.ValidarFormatoSenhaController;
import controller.VerificarSeClienteExisteController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Conta;

import java.util.Scanner;

public class AbrirContaView {
    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public AbrirContaView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void abrirConta(){
        ValidarCpfCnpj validarCpfCnpj = new ValidarCpfCnpj();
        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController(bancoDeDados, contaLogada);

        TipoDeCliente tipoDeCliente = null;
        TipoDeConta tipoDeConta;
        String senhaEscolhida;

        System.out.println("Escolha o tipo de conta que deseja abrir (FISICA ou JURIDICA)" +
                "\ndigitando seu CPF ou CNPJ");

        String numeroDocumento = input.nextLine();

        if(validarCpfCnpj.isCPF(numeroDocumento) || validarCpfCnpj.isCNPJ(numeroDocumento)){
            if(validarCpfCnpj.isCPF(numeroDocumento)){
                tipoDeCliente = TipoDeCliente.PESSOA_FISICA;
            } else if(validarCpfCnpj.isCNPJ(numeroDocumento)){
                tipoDeCliente = TipoDeCliente.PESSOA_JURIDICA;
            }
        } else {
            System.out.println("Documento invalido");
            MenuInicialView menuInicialView = new MenuInicialView(bancoDeDados);
            menuInicialView.mostrarMenuInicial();
        }

        if(!verificarSeClienteExisteController.verificarSeClienteExiste(numeroDocumento)) {
            CadastrarClienteView cadastrarClienteView = new CadastrarClienteView(bancoDeDados, contaLogada);
            cadastrarClienteView.cadastrarCliente(numeroDocumento, tipoDeCliente);
        }

        tipoDeConta = escolherTipoDeConta(tipoDeCliente);
        senhaEscolhida = escolherSenha();

        AbrirContaController abrirContaController = new AbrirContaController(bancoDeDados, contaLogada);
        abrirContaController.abrirConta(numeroDocumento, senhaEscolhida, tipoDeConta);
    }

    public TipoDeConta escolherTipoDeConta (TipoDeCliente tipoDeCliente) {
        TipoDeConta tipoDeConta = null;

        System.out.println("Deseja abrir uma conta:" +
                "\n1 - CORRENTE");
        System.out.println("2 - INVESTIMENTO");
        if(tipoDeCliente.equals(TipoDeCliente.PESSOA_FISICA)){
            System.out.println("3 - POUPANCA");
        }

        try {
            int tipoDeconta = Integer.parseInt(input.nextLine());
            if (tipoDeconta == 1 || tipoDeconta == 2 || tipoDeconta == 3) {

                switch (tipoDeconta) {
                    case 1 -> {
                        System.out.println("-----------------------------------------------------");
                        tipoDeConta = TipoDeConta.CONTA_CORRENTE;
                    }
                    case 2 -> {
                        System.out.println("-----------------------------------------------------");
                        tipoDeConta = TipoDeConta.CONTA_INVESTIMENTO;
                    }
                    case 3 -> {
                        if(tipoDeCliente.equals(TipoDeCliente.PESSOA_FISICA)){
                            System.out.println("-----------------------------------------------------");
                            tipoDeConta = TipoDeConta.CONTA_POUPANCA;
                        } else {
                            System.out.println("Opcao invalida. Tente novamente.");
                            escolherTipoDeConta(tipoDeCliente);
                        }
                    }
                    default -> {
                        System.out.println("Opcao invalida. Tente novamente.");
                        escolherTipoDeConta(tipoDeCliente);
                    }
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                escolherTipoDeConta(tipoDeCliente);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
            escolherTipoDeConta(tipoDeCliente);
        }
        return tipoDeConta;
    }
    public String escolherSenha() {

        ValidarFormatoSenhaController validarFormatoSenhaController = new ValidarFormatoSenhaController();
        String senhaValidada = null;

        System.out.println("Digite uma senha para sua conta" +
                "\nA senha deve conte pelo menos:" +
                "\n8 caracteres" +
                "\n1 letra maiuscula" +
                "\n1 letra minuscula" +
                "\n1 Caractere especial");

        String senhaDigitada = input.nextLine();

        if (!validarFormatoSenhaController.validarSenha(senhaDigitada)) {
            System.out.println("Digite uma senha valida");
            escolherSenha();
        } else {
            senhaValidada = senhaDigitada;
        }
        return senhaValidada;
    }
}

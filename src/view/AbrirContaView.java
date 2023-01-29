package view;

import controller.AbrirContaController;
import controller.ValidarCpfCnpjController;
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

    public AbrirContaView(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    ValidarCpfCnpjController validarCpfCnpj = new ValidarCpfCnpjController();

    public void abrirConta() {
        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController(bancoDeDados, contaLogada);

        String numeroDocumentoInformado = informarDocumento();
        TipoDeCliente tipoDeCliente = escolherTipoDeCliente(numeroDocumentoInformado);
        TipoDeConta tipoDeConta = escolherTipoDeConta(tipoDeCliente);
        String senhaEscolhida = escolherSenha();

        if (!verificarSeClienteExisteController.verificarSeClienteExiste(numeroDocumentoInformado)) {
            CadastrarClienteView cadastrarClienteView = new CadastrarClienteView(bancoDeDados, contaLogada);
            cadastrarClienteView.cadastrarCliente(numeroDocumentoInformado, tipoDeCliente);
        }

        AbrirContaController abrirContaController = new AbrirContaController(bancoDeDados, contaLogada);
        abrirContaController.abrirConta(numeroDocumentoInformado, senhaEscolhida, tipoDeConta);
    }

    public String informarDocumento(){
        System.out.println("Escolha o tipo de conta que deseja abrir (FISICA ou JURIDICA)" +
                "\ndigitando seu CPF ou CNPJ");
        String numeroDocumento = input.nextLine();

        if (validarCpfCnpj.isCPF(numeroDocumento) || validarCpfCnpj.isCNPJ(numeroDocumento)) {
            return numeroDocumento;
        }
        else {
            System.out.println("Documento invalido");
        }
        return informarDocumento();
    }

    public TipoDeCliente escolherTipoDeCliente(String numeroDocumento){
        if (validarCpfCnpj.isCPF(numeroDocumento) || validarCpfCnpj.isCNPJ(numeroDocumento)) {
            if (validarCpfCnpj.isCPF(numeroDocumento)) {
                return TipoDeCliente.PESSOA_FISICA;
            } else if (validarCpfCnpj.isCNPJ(numeroDocumento)) {
                return TipoDeCliente.PESSOA_JURIDICA;
            }
        }
        return escolherTipoDeCliente(numeroDocumento);
    }

    public TipoDeConta escolherTipoDeConta(TipoDeCliente tipoDeCliente) {

        System.out.println("Deseja abrir uma conta:" +
                "\n1 - CORRENTE");
        System.out.println("2 - INVESTIMENTO");
        if (tipoDeCliente.equals(TipoDeCliente.PESSOA_FISICA)) {
            System.out.println("3 - POUPANCA");
        }

        try {
            int escolhaConta = Integer.parseInt(input.nextLine());
            if (escolhaConta == 1 || escolhaConta == 2 || escolhaConta == 3) {

                switch (escolhaConta) {
                    case 1 -> {
                        System.out.println("-----------------------------------------------------");
                        return TipoDeConta.CONTA_CORRENTE;
                    }
                    case 2 -> {
                        System.out.println("-----------------------------------------------------");
                        return TipoDeConta.CONTA_INVESTIMENTO;
                    }
                    case 3 -> {
                        if (tipoDeCliente.equals(TipoDeCliente.PESSOA_FISICA)) {
                            System.out.println("-----------------------------------------------------");
                            return TipoDeConta.CONTA_POUPANCA;
                        } else {
                            System.out.println("Opcao invalida. Tente novamente.");
                        }
                    }
                    default -> {
                        System.out.println("Opcao invalida. Tente novamente.");
                    }
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
        }
        return escolherTipoDeConta(tipoDeCliente);
    }

    public String escolherSenha() {

        ValidarFormatoSenhaController validarFormatoSenhaController = new ValidarFormatoSenhaController();

        System.out.println("Digite uma senha para sua conta" +
                "\nA senha deve conte pelo menos:" +
                "\n8 caracteres" +
                "\n1 letra maiuscula" +
                "\n1 letra minuscula" +
                "\n1 Caractere especial");

        String senhaDigitada = input.nextLine();

        if (!validarFormatoSenhaController.validarSenha(senhaDigitada)) {
            System.out.println("Digite uma senha valida");
        } else {
            return senhaDigitada;
        }
        return escolherSenha();
    }
}

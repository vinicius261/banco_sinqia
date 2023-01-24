package view;

import controller.AbrirContaController;
import controller.ValidarCpfCnpj;
import controller.ValidarSenhaController;
import controller.VerificarSeClienteExisteController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Cliente;

import java.util.Scanner;

public class CadastrarContaPessoaJuridicaView {
    static final Scanner input = new Scanner(System.in);
    public void cadastrarContaPessoJuridica() {
        ValidarCpfCnpj validarCpfCnpj = new ValidarCpfCnpj();
        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController();

        TipoDeCliente tipoDeCliente = TipoDeCliente.PESSOA_JURIDICA;
        String senhaValidada;
        Cliente cliente = null;

        System.out.println("Digite seu CNPJ");
        String numeroDocumento = input.nextLine();
        if (validarCpfCnpj.isCNPJ(numeroDocumento)) {
            if (verificarSeClienteExisteController.verificarSeClienteExiste(numeroDocumento)) {
                cliente = verificarSeClienteExisteController.procurarCliente(numeroDocumento);
            } else {
                CadastrarClienteView cadastrarClienteView = new CadastrarClienteView();
                cadastrarClienteView.cadastrarCliente(numeroDocumento, tipoDeCliente);
            }
        } else {
            System.out.println("Documento invalido");
            MenuInicialView menuInicialView = new MenuInicialView();
            menuInicialView.mostrarMenuInicial();
        }
        public TipoDeConta escolherTipoDeConta(){
            TipoDeConta tipoDeConta = null;

            System.out.println("Deseja abrir uma conta:" +
                    "\n1 - CORRENTE" +
                    "\n2 - POUPANCA" +
                    "\n3 - INVESTIMENTO");
            try {
                int tipoDeconta = Integer.parseInt(input.nextLine());
                if (tipoDeconta == 1 || tipoDeconta == 2 || tipoDeconta == 3) {

                    switch (tipoDeconta) {
                        case 1:
                            System.out.println("-----------------------------------------------------");
                            tipoDeConta = TipoDeConta.CONTA_CORRENTE;
                            break;

                        case 2:
                            System.out.println("-----------------------------------------------------");
                            tipoDeConta = TipoDeConta.CONTA_POUPANCA;
                            break;

                        case 3:
                            System.out.println("-----------------------------------------------------");
                            tipoDeConta = TipoDeConta.CONTA_INVESTIMENTO;
                            break;

                        default:
                            System.out.println("Opcao invalida. Tente novamente.");
                            cadastrarContaPessoJuridica();
                    }
                } else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    cadastrarContaPessoJuridica();
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um numero.");
                cadastrarContaPessoJuridica();
            }
            return tipoDeConta;
        }
        public String escolherSenha(){

            ValidarSenhaController validarSenhaController = new ValidarSenhaController();
            String senhaValidada = null;

            System.out.println("Digite uma senha para sua conta" +
                    "\nA senha deve conte pelo menos:" +
                    "\n8 caracteres" +
                    "\n1 letra maiuscula" +
                    "\n1 letra minuscula" +
                    "\n1 Caractere especial");

            String senhaDigitada = input.nextLine();

            if(!validarSenhaController.validarSenha(senhaDigitada)){
                System.out.println("Digite uma senha valida");
                escolherSenha();
            } else {
                senhaValidada = senhaDigitada;
            }
            return senhaValidada;
        }

    }
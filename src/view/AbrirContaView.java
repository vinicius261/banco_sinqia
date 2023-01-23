package view;

import controller.ValidarCpfCnpj;
import controller.VerificarSeClienteExisteController;

import java.util.Scanner;

public class AbrirContaView {
    static final Scanner input = new Scanner(System.in);


    public void abrirConta(){
        CadastrarContaPessoFisicaView cadastrarContaPessoFisicaView = new CadastrarContaPessoFisicaView();
        CadastrarContaPessoaJuridicaView cadastrarContaPessoaJuridicaView = new CadastrarContaPessoaJuridicaView();

        System.out.println("Deseja abrir uma conta para pessoa:" +
                "\n1 -  FISICA" +
                "\n2 - JURIDICA");
        try {
            int tipoDeconta = Integer.parseInt(input.nextLine());
            if (tipoDeconta == 1 || tipoDeconta == 2) {
                int opcao = tipoDeconta;
                switch (opcao) {
                    case 1:
                        System.out.println("-------------------------- PESSOA FISICA ---------------------------");
                        cadastrarContaPessoFisicaView.cadastrarContaPessoFisica();
                        break;

                    case 2:
                        System.out.println("-------------------------- PESSOA JURIDICA ---------------------------");
                        cadastrarContaPessoaJuridicaView.cadastrarContaPessoJuridica();
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        abrirConta();
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                abrirConta();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
            abrirConta();
        }
    }

    public void VerificarTipoPessoa(){
        String numeroDocumento = input.nextLine();

        ValidarCpfCnpj validarCpfCnpj = new ValidarCpfCnpj();
        VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController();


         if(validarCpfCnpj.isCNPJ(numeroDocumento)){
            if(verificarSeClienteExisteController.verificarSeClienteExiste(numeroDocumento)){

            } else{
                System.out.println("Cadastrando cliente");
                // chamar a view para cadastrar cliente
            }
        } else{
            System.out.println("Documento invalido");
            MenuInicialView menuInicialView = new MenuInicialView();
            menuInicialView.mostrarMenuInicial();
        }
    }
}

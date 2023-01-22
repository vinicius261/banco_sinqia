package view;

import java.util.Scanner;

import controller.ValidarCpfCnpj;
import controller.VerificarSeClienteExisteController;

public class AbrirContaView {

    static final Scanner input = new Scanner(System.in);

    //completar classe-metodo - coloquei um sout pra ver se funcionava
    public void abrirConta(){
        System.out.println("abrindo conta");
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
                        abrirContaPessoaFisica();
                        break;

                    case 2:
                        System.out.println("-------------------------- PESSOA JURIDICA ---------------------------");
                        abrirContaPessoaJuridica();
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

    public void abrirContaPessoaFisica(){
        System.out.println("Digite seu CPF");
        String CPF = input.nextLine();
        System.out.println(CPF);
        ValidarCpfCnpj validarCpfCnpj = new ValidarCpfCnpj();
        if(validarCpfCnpj.isCPF(CPF)){
            VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController();
            if(verificarSeClienteExisteController.verificarSeClienteExiste(CPF)){
                CadastrarContaPessoFisicaView cadastrarContaPessoFisicaView = new CadastrarContaPessoFisicaView();
                cadastrarContaPessoFisicaView.cadastrarContaPessoFisica();
            } else{
                System.out.println("Ir para cadastrar cliente");
                // chamar a view para cadastrar cliente
            }
        } else{
            System.out.println("CPF invalido");
            MenuInicialView menuInicialView = new MenuInicialView();
            menuInicialView.mostrarMenuInicial();
        }
    }

    public void abrirContaPessoaJuridica(){
        System.out.println("Digite seu CNPJ");
        String CNPJ = input.nextLine();
        ValidarCpfCnpj validarCpfCnpj = new ValidarCpfCnpj();
        if(validarCpfCnpj.isCNPJ(CNPJ)){
            VerificarSeClienteExisteController verificarSeClienteExisteController = new VerificarSeClienteExisteController();
            if(verificarSeClienteExisteController.verificarSeClienteExiste(CNPJ)){
                CadastrarContaPessoaJuridicaView cadastrarContaPessoaJuridicaView = new CadastrarContaPessoaJuridicaView();
                cadastrarContaPessoaJuridicaView.cadastrarContaPessoaJuridica();
            } else{
                // chamar a view para cadastrar cliente
            }
        } else{
            System.out.println("CNPJ invalido");
            MenuInicialView menuInicialView = new MenuInicialView();
            menuInicialView.mostrarMenuInicial();
        }
    }
}

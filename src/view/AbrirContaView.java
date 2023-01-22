package view;

import java.util.Scanner;

import controller.ValidarDocumentoController;

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
        ValidarDocumentoController validarDocumentoController = new ValidarDocumentoController();
//        validarDocumentoController.validarDocumento();
        if(validarDocumentoController.isCPF(CPF) == true){
            validarDocumentoController.imprimeCPF(CPF);
        } else{
            System.out.println("Não é CPF");
        }


    }

    public void abrirContaPessoaJuridica(){

    }
}

package view;

import controller.BuscarEmailController;
import controller.CadastrarClienteController;
import controller.ValidarEmailController;
import database.BancoDeDados;
import enums.TipoDeCliente;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastrarClienteView {
    static final Scanner input = new Scanner(System.in);
    CadastrarClienteController controller;
    ValidarEmailController validarEmailController;
    BuscarEmailController buscarEmailController;
    private String cadastroNome;
    private String cadastroEmail;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public CadastrarClienteView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.controller = new CadastrarClienteController(bancoDeDados, contaLogada);
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public void cadastrarCliente(String documento, TipoDeCliente tipoDeCliente){
        ArrayList<Conta> contasDoCliente = new ArrayList<>();
        Cliente c = controller.cadastrarCliente(cadastroNome(), documento, cadastroEmail(), tipoDeCliente, contasDoCliente);
        }

    private String cadastroNome() {
        System.out.println("Por favor, digite seu NOME: ");
        cadastroNome = input.nextLine();
        if (cadastroNome != null && cadastroNome.length() > 1) {
            System.out.println("Nome cadastrado.");
        } else {
            System.out.println("O nome e obrigatorio.");
            cadastroNome();
        }
        return cadastroNome;
    }

    private String cadastroEmail() {
        System.out.println("Insira seu login (e-mail):");
        cadastroEmail = input.nextLine();
        if (validarEmailController.validar(cadastroEmail) == true && buscarEmailController.buscaEmail(cadastroEmail) == false) {
            System.out.println("Email cadastrado.");
        } else {
            System.out.println("E-mail invalido. Tente novamente");
            cadastroEmail();
        }
        return cadastroEmail;
    }
}

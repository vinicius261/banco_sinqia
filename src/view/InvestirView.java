package view;

import database.BancoDeDados;
import enums.TipoDeCliente;
import model.Conta;

import java.util.Scanner;

public class InvestirView {

    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public InvestirView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }
    public void investirView() {
        System.out.println("Bem vindo a sua area de investimentos!\n\n");
        if (contaLogada.getCliente().getTipoDeCliente() == TipoDeCliente.PESSOA_FISICA){
            System.out.println("Para investir basta abrir uma conta poupança ou conta investimento\n" +
                    "que seus depósitos e transferências para elas já passam a render.\n\n" +
                    "Conta-poupança rende 1% e Conta-investimento 1.5%\n");
        } else {
            System.out.println("Para investir basta abrir uma conta investimento\n" +
                    "que seus depósitos e transferências para ela já passam a render 3.5%.\n\n");
        }

        System.out.println("Se deseja abrir uma conta com rendimentos pressione 1 ou qualquer tecla para voltar ao menu.\n");
        if (confirmaAcao(input.nextLine())){
            AbrirContaView abrirContaView = new AbrirContaView(bancoDeDados, contaLogada);
            abrirContaView.abrirConta(contaLogada);
        }else {
            MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
            menuContaView.mostrarMenuConta();
        }


    }

    public boolean confirmaAcao(String input) {
        Integer resposta = 2;

        try {
            resposta = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        if (resposta == 1) {
            return true;
        } else {
            return false;
        }
    }

}


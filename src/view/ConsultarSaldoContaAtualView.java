package view;

import controller.ConsultarSaldoController;
import controller.ProcurarOutraContaController;
import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class ConsultarSaldoContaAtualView {
    static final Scanner input = new Scanner(System.in);
    ConsultarSaldoController consultarSaldoController;
    ProcurarOutraContaController procurarOutraContaController;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public ConsultarSaldoContaAtualView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
        this.consultarSaldoController = new ConsultarSaldoController(bancoDeDados, contaLogada);
        this.procurarOutraContaController = new ProcurarOutraContaController(bancoDeDados, contaLogada);
    }


    public void SaldoContaAtual() {
        double saldo = consultarSaldoController.SaldoContaLogada();
        MenuContaView menuContaView = new MenuContaView(bancoDeDados, contaLogada);
        System.out.println("Saldo disponivel: R$" + saldo);
        if(procurarOutraContaController.verificarSeClientePossuiOutraConta()){
            System.out.println("Deseja consultar o saldo de suas demais contas?" +
                    "\n1 - Sim " +
                    "\n2 - Nao");
            int opcao = Integer.parseInt(input.nextLine());
            switch (opcao){
                case 1 :
                    ConsultarSaldoOutrasContasView consultarSaldoOutrasContasView = new ConsultarSaldoOutrasContasView(bancoDeDados, contaLogada);
                    consultarSaldoOutrasContasView.SaldoOutraConta();
                    menuContaView.mostrarMenuConta();
                    break;
                case 2 :
                    menuContaView.mostrarMenuConta();
                    break;
                default:
                    System.out.println("Opçao Invalida");
                    menuContaView.mostrarMenuConta();
            }
        } else {
            menuContaView.mostrarMenuConta();
        }

    }


}

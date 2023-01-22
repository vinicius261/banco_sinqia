package view;

import controller.ConsultarSaldoController;
import controller.ProcurarOutraContaController;

import java.util.Scanner;

public class ConsultarSaldoContaAtualView {
    static final Scanner input = new Scanner(System.in);
    ConsultarSaldoController consultarSaldoController = new ConsultarSaldoController();
    ProcurarOutraContaController procurarOutraContaController = new ProcurarOutraContaController();


    public void SaldoContaAtual() {
        double saldo = consultarSaldoController.SaldoContaLogada();
        System.out.println("Saldo disponivel: " + saldo);
        if(procurarOutraContaController.verificarSeClientePossuiOutraConta()){
            System.out.println("Deseja consultar o saldo de suas demais contas?" +
                    "\n1 - Sim " +
                    "\n2 - Nao");
        }
        int opcao = Integer.parseInt(input.nextLine());
        switch (opcao){
            case 1 :
                ConsultarSaldoOutrasContasView consultarSaldoOutrasContasView = new ConsultarSaldoOutrasContasView();
                consultarSaldoOutrasContasView.SaldoOutraConta();
                break;
            case 2 :
                MenuContaView menuContaView = new MenuContaView();
                menuContaView.mostrarMenuConta();
        }
    }


}
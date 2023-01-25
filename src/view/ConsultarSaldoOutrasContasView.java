package view;

import controller.ConsultarSaldoController;
import model.Conta;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarSaldoOutrasContasView {
    static final Scanner input = new Scanner(System.in);
    ConsultarSaldoController consultarSaldoController = new ConsultarSaldoController();
    public void SaldoOutraConta() {
        String opcao;
        ArrayList<Conta> contas = consultarSaldoController.SaldoOutraConta();

            System.out.println("Digite o numero da conta de que deseja consultar o saldo");
            for(int i = 0; i < contas.size(); i++){
                switch (contas.get(i).getTipoDeConta()) {
                    case CONTA_POUPANCA -> {
                        System.out.println(contas.get(i).getNumeroConta() + " - POUPANCA");
                    }
                    case CONTA_CORRENTE -> {
                        System.out.println(contas.get(i).getNumeroConta() + " - CORRENTE");
                    }
                    case CONTA_INVESTIMENTO -> {
                        System.out.println(contas.get(i).getNumeroConta() + " - INVESTIMENTO");
                    }
                }
            }

            opcao = input.nextLine();
            boolean numeroValido = false;

            for(Conta conta : contas){
                if(conta.getNumeroConta().equals(opcao)){
                    numeroValido = true;
                    System.out.println("O saldo da conta é: R$" + conta.getSaldo());
                    break;
                }
            }
            if(!numeroValido){
                System.out.println("Numero invalido");
                SaldoOutraConta();
            }
    }
}

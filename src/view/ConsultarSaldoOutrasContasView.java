package view;

import controller.ConsultarSaldoController;
import model.Conta;
import enums.TipoDeConta;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ConsultarSaldoOutrasContasView {
    static final Scanner input = new Scanner(System.in);
    ConsultarSaldoController consultarSaldoController = new ConsultarSaldoController();
    public void SaldoOutraConta() {
        String contaSelecionada = null;
        String tipoDeConta = null;
        String opcao;
        double saldo = 0;
        ArrayList<Conta> contas = consultarSaldoController.SaldoOutraConta();

        System.out.println("Digite o tipo da conta de que deseja consultar o saldo");
        for(int i = 0; i < contas.size(); i++){
            switch (contas.get(i).getTipoDeConta()) {
                case CONTA_POUPANCA -> {
                    contaSelecionada = "POUPANCA";
                }
                case CONTA_CORRENTE -> {
                    contaSelecionada = "CORRENTE";
                }
                case CONTA_INVESTIMENTO -> {
                    contaSelecionada = "INVESTIMENTO";
                }
            }
            System.out.println(contaSelecionada);
        }
        opcao = input.nextLine().toUpperCase();

        switch (opcao) {
            case "POUPANCA" -> {
                for(Conta conta : contas){
                    if(conta.getTipoDeConta().equals(TipoDeConta.CONTA_POUPANCA)){
                        saldo = conta.getSaldo();
                    }
                }
                System.out.println("O saldo da sua conta poupanca e de: " + saldo);
            }
            case "CORRENTE" -> {
                for(Conta conta : contas){
                    if(conta.getTipoDeConta().equals(TipoDeConta.CONTA_CORRENTE)){
                        saldo = conta.getSaldo();
                    }
                }
                System.out.println("O saldo da sua conta corrente e de: " + saldo);
            }
            case "INVESTIMENTO" -> {
                for(Conta conta : contas){
                    if(conta.getTipoDeConta().equals(TipoDeConta.CONTA_INVESTIMENTO)){
                        saldo = conta.getSaldo();
                    }
                }
                System.out.println("O saldo da sua conta investimento e de: " + saldo);
            }
        }
    }
}

package controller;

import database.BancoDeDados;
import enums.TipoDeConta;
import model.Cliente;

import static database.BancoDeDados.*;

public class ConsultarSaldoOutraContaController {
    public double saldoOutraConta(String TipoDeConta){
        String tipoDeConta = TipoDeConta;
        double saldo = 0;

        Cliente cliente = BancoDeDados.getContaLogada().getCliente();

        switch (tipoDeConta) {
            case "POUPANCA" -> {

                System.out.println("O saldo da sua conta poupanca e de: " + saldo);
            }
            case "CORRENTE" -> {
                System.out.println("O saldo da sua conta corrente e de: " + saldo);
            }
            case "INVESTIMENTO" -> {
                System.out.println("O saldo da sua conta investimento e de: " + saldo);
            }
        }
        return saldo;
    }
}

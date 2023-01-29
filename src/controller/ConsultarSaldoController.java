package controller;

import database.BancoDeDados;
import model.Conta;

import java.util.ArrayList;
import java.util.Objects;

public class ConsultarSaldoController {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public ConsultarSaldoController(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }
    public double SaldoContaLogada(){
        return this.contaLogada.getSaldo();
    }

    public ArrayList<Conta> SaldoOutraConta(){
        ArrayList<Conta> contasDoCliente = contaLogada.getCliente().getContasDoCliente();

        for (Conta conta : contasDoCliente){
                if(!Objects.equals(conta, contaLogada)){
                    contasDoCliente.add(conta);
                }
        }
        return contasDoCliente;
    }
}



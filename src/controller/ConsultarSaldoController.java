package controller;

import database.BancoDeDados;
import model.Conta;

import static database.BancoDeDados.*;

import java.util.ArrayList;
import java.util.Objects;

public class ConsultarSaldoController {

    public double SaldoContaLogada(){
        return getContaLogada().getSaldo();
    }

    public ArrayList<Conta> SaldoOutraConta(){
        ArrayList<Conta> contasDoCliente = new ArrayList<>();
        Conta contaLogada = getContaLogada();

        for (Conta conta : BancoDeDados.getContas()){
            if(Objects.equals(contaLogada.getCliente(), conta.getCliente())){
                if(!Objects.equals(conta, contaLogada)){
                    contasDoCliente.add(conta);
                }
            }
        }
        return contasDoCliente;
    }
}



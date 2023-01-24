package controller;

import model.Conta;
import static database.BancoDeDados.*;

import java.util.Objects;

public class ProcurarOutraContaController {
    public boolean verificarSeClientePossuiOutraConta(){
        boolean existeOutraConta = false;
        for(Conta conta : getContas()){
            if(Objects.equals(conta.getCliente(), getContaLogada().getCliente())){
                if(!conta.equals(getContaLogada())){
                    existeOutraConta = true;
                    break;
                }
            }
        }
        return existeOutraConta;
    }
}

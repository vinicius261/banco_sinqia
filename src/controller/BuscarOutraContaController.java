package controller;

import database.BancoDeDados;
import model.Conta;

import java.util.Objects;

public class BuscarOutraContaController {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public BuscarOutraContaController(BancoDeDados bancoDeDados, Conta contaLogada) {
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public boolean verificarSeClientePossuiOutraConta() {
        boolean existeOutraConta = false;
        for (Conta conta : bancoDeDados.getContas()) {
            if (Objects.equals(conta.getCliente(), this.contaLogada.getCliente())) {
                if (!conta.equals(this.contaLogada)) {
                    existeOutraConta = true;
                    break;
                }
            }
        }
        return existeOutraConta;
    }
}

package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class CadastrarClienteController {

    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public CadastrarClienteController(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }

    public Cliente cadastrarCliente(
            String nome,
            String documento,
            String email,
            TipoDeCliente tipoDeCliente,
            ArrayList<Conta> contasDoCliente
    ) {
        Cliente cliente = new Cliente(nome, documento, email, tipoDeCliente, contasDoCliente);
        bancoDeDados.addCliente(cliente);
        return cliente;
    }
}

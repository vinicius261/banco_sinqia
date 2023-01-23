package controller;

import enums.TipoDeCliente;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class CadastrarClienteController {

    public void cadastrarCliente(
            String nome,
            String documento,
            String email,
            TipoDeCliente tipoDeCliente,
            ArrayList<Conta> contasDoCliente
    ) {
        Cliente cliente = new Cliente(nome, documento, email, tipoDeCliente, contasDoCliente);


    }
}

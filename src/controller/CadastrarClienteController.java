package controller;

import database.BancoDeDados;
import enums.TipoDeCliente;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastrarClienteController {

    public boolean validaEmail(String email) {
        boolean validacaoEmail = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                validacaoEmail = true;
            }
        }
        return validacaoEmail;
    }

    public boolean buscaEmail(String email) {
        boolean emailExiste = false;
        for (int i = 0; i < BancoDeDados.getClientes().size(); i++) {
            if (BancoDeDados.getClientes().get(i).getEmail().equals(email)) {
                emailExiste = true;
                System.out.println("Email já cadastrado.");
            }
        }
        return emailExiste;
    }

    public Cliente cadastrarCliente(
            String nome,
            String documento,
            String email,
            TipoDeCliente tipoDeCliente,
            ArrayList<Conta> contasDoCliente
    ) {
        Cliente cliente = new Cliente(nome, documento, email, tipoDeCliente, contasDoCliente);
        return cliente;
    }
}

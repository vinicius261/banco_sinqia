package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Cliente;
import model.ContaCorrente;
import database.BancoDeDados.*;
import model.ContaPoupanca;

public class CriarContasClientes {
    public void CriarContasClientes(){
        Cliente cliente = new Cliente();
        cliente.setTipoDeCliente(TipoDeCliente.PESSOA_FISICA);
        cliente.setDocumento("111");
        cliente.SetNome("Lucas");
        BancoDeDados.addCliente(cliente);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(100);
        contaCorrente.setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
        BancoDeDados.addConta(contaCorrente);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setCliente(cliente);
        contaPoupanca.setSaldo(50);
        contaPoupanca.setTipoDeConta(TipoDeConta.CONTA_POUPANCA);
        BancoDeDados.addConta(contaPoupanca);

        BancoDeDados.setContaLogada(contaPoupanca);
    }
}


package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

public class CriarContasClientes {
    public void CriarContasClientes(){
        Cliente cliente = new Cliente();
        cliente.setTipoDeCliente(TipoDeCliente.PESSOA_FISICA);
        cliente.setDocumento("38129476843");
        cliente.setNome("Lucas");
        BancoDeDados.addCliente(cliente);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo(100);
        contaCorrente.setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
        contaCorrente.setNumeroConta("1");
        contaCorrente.setSenha("1");
        BancoDeDados.addConta(contaCorrente);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setCliente(cliente);
        contaPoupanca.setSaldo(50);
        contaPoupanca.setTipoDeConta(TipoDeConta.CONTA_POUPANCA);
        contaPoupanca.setNumeroConta("2");
        BancoDeDados.addConta(contaPoupanca);

//        ContaInvestimento contaInvestimento = new ContaInvestimento();
//        contaInvestimento.setCliente(cliente);
//        contaInvestimento.setSaldo(1000);
//        contaInvestimento.setTipoDeConta((TipoDeConta.CONTA_INVESTIMENTO));
//        BancoDeDados.addConta(contaInvestimento);

        BancoDeDados.setContaLogada(contaPoupanca);
    }
}


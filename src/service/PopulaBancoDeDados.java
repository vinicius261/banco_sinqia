package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import enums.TipoDeConta;
import model.Cliente;
import model.ContaCorrente;
import model.ContaInvestimento;
import model.ContaPoupanca;

public class PopulaBancoDeDados {

    public void cadastroDeContasFicticias(){
        String[] nomes = {"Cassio Ramos","Murilo Moura", "Patricia Souza", "Kaio Nascimento", "Gisele Lopes"};
        String[] documentos = {"445.068.140-10", "575.483.740-20", "820.904.520-21", "133.442.460-89", "038.785.940-38"};
        String[] email = {"ramos@gmail.com", "moura@gmail.com", "souza@gmail.com", "nascimento@gmail.com", "lopes@gmail.com" };
        String[] dataDeNascimento = {"12/12/1988", "11/06/1977", "15/04/1965", "21/01/2000", "16/08/1981"};
        TipoDeCliente[] tipoDeCliente = {TipoDeCliente.PESSOA_FISICA, TipoDeCliente.PESSOA_FISICA, TipoDeCliente.PESSOA_FISICA, TipoDeCliente.PESSOA_JURIDICA, TipoDeCliente.PESSOA_JURIDICA};

        for (int i = 0; i < 5; i++) {
            Cliente novo = new Cliente();
            novo.setNome(nomes[i]);
            novo.setDocumento(documentos[i]);
            novo.setEmail(email[i]);
            novo.setDataDenascimento(dataDeNascimento[i]);
            novo.setTipoDeCliente(tipoDeCliente[i]);
            BancoDeDados.addCliente(novo);
        }

        for (int i = 0; i < 2; i++) {
            ContaCorrente contaCorrente = new ContaCorrente();
            contaCorrente.setNumeroConta(i + "00");
            contaCorrente.setSenha("123465");
            contaCorrente.setSaldo(500);
            contaCorrente.setCliente(BancoDeDados.getClientes().get(i));
            contaCorrente.setTipoDeConta(TipoDeConta.CONTA_CORRENTE);
            BancoDeDados.addConta(contaCorrente);
        }

        for (int i = 2; i < 4; i++) {
            ContaPoupanca contaPoupanca = new ContaPoupanca();
            contaPoupanca.setNumeroConta(i + "00");
            contaPoupanca.setSenha("123456");
            contaPoupanca.setSaldo(500);
            contaPoupanca.setCliente(BancoDeDados.getClientes().get(i));
            contaPoupanca.setTipoDeConta(TipoDeConta.CONTA_POUPANCA);
            BancoDeDados.addConta(contaPoupanca);
        }

        for (int i = 2; i < 4; i++) {
            ContaInvestimento contaInvestimento = new ContaInvestimento();
            contaInvestimento.setNumeroConta(i + "00");
            contaInvestimento.setSenha("123456");
            contaInvestimento.setSaldo(500);
            contaInvestimento.setCliente(BancoDeDados.getClientes().get(i));
            contaInvestimento.setTipoDeConta(TipoDeConta.CONTA_INVESTIMENTO);
            BancoDeDados.addConta(contaInvestimento);
        }

    }

}

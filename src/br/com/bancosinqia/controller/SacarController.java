package br.com.bancosinqia.controller;

public class SacarController {

    public Double validaValorDoSaque(String valor){
        Double valorDoSaque = 0.0;

        try {
            valorDoSaque = Double.parseDouble(valor);
        }catch (NumberFormatException ex){
            return valorDoSaque;
        }

        return valorDoSaque;
    }

    public boolean validaSaldo(Conta conta, Double valorDoSaque){

        if (conta.getSaldo >= valorDoSaque){
            return true;
        }

        return false;
    }

    public Conta validaContaDoSaque(List<Conta> listaDeContas, String numeroDaConta) {
        Conta contaDoSaque = null;

        for (Conta conta: listaDeContas) {
            if (numeroDaConta.equals(conta.getNumeroConta())){
                contaDoSaque = conta;
                break;
            }
        }

        return contaDoSaque;
    }
}

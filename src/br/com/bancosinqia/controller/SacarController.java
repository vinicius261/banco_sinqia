package br.com.bancosinqia.controller;

public class SacarController {

    public Integer validaValorDoSaque(String valor){
        Integer valorDoSaque = 0;

        try {
            valorDoSaque = Integer.parseInt(valor);
        }catch (NumberFormatException ex){
            return 0;
        }

        return valorDoSaque;
    }

    public boolean validaSaldo(Conta conta, Integer valorDoSaque){

        if (conta.getSaldo >= valorDoSaque){
            return true;
        }

        return false;
    }

    public Conta validaContaDoSaque(List<Conta> listaDeContas,  String numeroDaConta) {
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

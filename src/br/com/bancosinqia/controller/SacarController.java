package br.com.bancosinqia.controller;

public class SacarController {

    public Integer validaInputDoSaque(String valor){
        Integer valorDoSaque = 0;

        try {
            valorDoSaque = Integer.parseInt(valor);
        }catch (NumberFormatException ex){
            return 0;
        }

        return valorDoSaque;
    }

    public boolean validaValorDoSaque(Integer valorDoSaque){
        if (valorDoSaque <= 0){
            return false;
        }

        return true;
    }

    public boolean validaSaldo(Integer valorDoSaque){

        if (Banco.contaLogada.getContaLogada().getSaldo() >= valorDoSaque){
            return true;
        }

        return false;
    }

    public void movimentaConta(Integer valorDoSaque){
        Conta contaLogada = Banco.contaLogada.getContaLogada();

        if (valorDoSaque > 0) {
            Double saldo  = contaLogada.getSaldo();
            contaLogada.setSaldo(saldo - valorDoSaque);
        }
    }

    /*public Conta validaContaDoSaque(List<Conta> listaDeContas,  String numeroDaConta) {
        Conta contaDoSaque = null;

        for (Conta conta: listaDeContas) {
            if (numeroDaConta.equals(conta.getNumeroConta())){
                contaDoSaque = conta;
                break;
            }
        }

        return contaDoSaque;
    }*/
}

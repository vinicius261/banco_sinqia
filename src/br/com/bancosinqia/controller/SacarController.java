package br.com.bancosinqia.controller;

public class SacarController {

    public boolean validaSenha(Conta conta, String senhaDigitada){
        if (senhaDigitada.equals(conta.getSenha())){
            return true;
        }else {
            return false;
        }
    }

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

    public boolean validaSaldo(Conta conta, Integer valorDoSaque){

        if (conta.getSaldo() >= valorDoSaque){
            return true;
        }

        return false;
    }

    public boolean movimentaConta(Conta conta, Integer valorDoSaque){
        if (valorDoSaque > 0) {
            Double saldo  = conta.getSaldo();
            conta.setSaldo(saldo - valorDoSaque);
            return true;
        }
        return false;
    }
}

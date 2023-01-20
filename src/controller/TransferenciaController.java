package controller;

public class TransferenciaController {
    public boolean validaSenha(Conta conta, String senhaDigitada){
        if (senhaDigitada.equals(conta.getSenha())){
            return true;
        }else {
            return false;
        }
    }

    public boolean validaValorDaTransferencia(Double valorDaTransferencia){
        if (valorDaTransferencia < 0){
            return false;
        }
        return true;
    }

    public boolean validaSaldo(Conta conta, Double valorDaTransferencia) {
        if (conta.getSaldo() >= valorDaTransferencia) {
            return true;
        } else {
            throw SaldoInsuficienteException("Saldo insuficiente para a transferência.\n Saldo atual: " + conta.getSaldo + "\n");
        }
    }

    public void transfereValores(Conta contaLogada, Conta contafavorecida, Double valorDaTransferencia){
        if (valorDaTransferencia > 0) {
            Double saldoFavorecida = contafavorecida.getSaldo();
            contafavorecida.setSaldo(saldoFavorecida + valorDaTransferencia);

            Double saldoContaLogada = contaLogada.getSaldo();
            contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);
        }
    }

    public Conta buscaContas(String nextLine) {

    }
}

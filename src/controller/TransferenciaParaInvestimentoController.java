package controller;

import enums.TipoDeConta;
import model.Conta;

public class TransferenciaParaInvestimentoController extends TransferenciaController {
    @Override
    public void transfereValores(Conta contaLogada, Conta contafavorecida, Double valorDaTransferencia){
        if (valorDaTransferencia > 0) {
            if(contaLogada.getTipoDeConta() == TipoDeConta.CONTA_INVESTIMENTO) {
                Double saldoFavorecida = contafavorecida.getSaldo();
                contafavorecida.setSaldo(saldoFavorecida + valorDaTransferencia + valorDaTransferencia * 0.035);

                Double saldoContaLogada = contaLogada.getSaldo();
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);

            } else if (contaLogada.getTipoDeConta() == TipoDeConta.CONTA_POUPANCA) {
                Double saldoFavorecida = contafavorecida.getSaldo();
                contafavorecida.setSaldo(saldoFavorecida + valorDaTransferencia + valorDaTransferencia * 0.015);

                Double saldoContaLogada = contaLogada.getSaldo();
                contaLogada.setSaldo(saldoContaLogada - valorDaTransferencia);
            }
        }
    }

}

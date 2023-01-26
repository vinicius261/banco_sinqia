package view;

import controller.TransferenciaParaInvestimentoController;
import database.BancoDeDados;
import model.Conta;

public class TranferenciaParaInvestimentosView extends  TransferenciaView{

    private TransferenciaParaInvestimentoController controller;
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public TranferenciaParaInvestimentosView(BancoDeDados bancoDeDados, Conta contaLogada) {
        super(bancoDeDados, contaLogada);
    }

    @Override
    public void movimentaConta(Double valorDaTransferencia, Conta contaFavorecida){
        controller.transfereValores(this.contaLogada, contaFavorecida, valorDaTransferencia);
        System.out.println("A transferência de " + valorDaTransferencia + "R$ para "
                + contaFavorecida.getCliente().getNome() + " foi feita.");
    }
}

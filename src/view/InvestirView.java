package view;

import controller.InvestirController;
import database.BancoDeDados;
import model.Conta;

import java.util.Scanner;

public class InvestirView {
    static final Scanner input = new Scanner(System.in);
    private BancoDeDados bancoDeDados;
    private Conta contaLogada;

    public InvestirView(BancoDeDados bancoDeDados, Conta contaLogada){
        this.bancoDeDados = bancoDeDados;
        this.contaLogada = contaLogada;
    }
    public void investirView() {
        System.out.println("Bem vindo a sua area de investimentos!");
        valorInvestimento();
        formaInvestimento();
        InvestirController investirController = new InvestirController(bancoDeDados, contaLogada);
        investirController.tipoInvestimento(valorInvestimento);
    }
        private double valorInvestimento;
        private double valorInvestimento() {
            System.out.println("Por favor, digite o valor que gostaria de investir: ");
            try {
                valorInvestimento = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um numero.");
                valorInvestimento();
            }
                if (valorInvestimento <= 0) {
                    System.out.println("Necessario investir um valor maior que zero.");
                    valorInvestimento();
                }
                return valorInvestimento;
        }

        private String formaInvestimento;
        private void formaInvestimento() {
            System.out.println("Qual a forma que voce gostaria de investir? " +
                    "Digite a opcao desejada:" +
                    "\n1 - DEPOSITO " +
                    "\n2 - TRANSFERENCIA");
           try {
            int formaInvestimento = Integer.parseInt(input.nextLine());
            if (formaInvestimento == 1 || formaInvestimento == 2) {
                int opcao = formaInvestimento;
                switch (opcao) {
                    case 1:
                        System.out.println("-------------------------- DEPOSITO ---------------------------");
                        DepositoView depositoView = new DepositoView(bancoDeDados, contaLogada);
                        depositoView.depositoDeslogadoView();
                        break;

                    case 2:
                        System.out.println("-------------------------- TRANSFERENCIA ---------------------------");
                        TranferenciaParaInvestimentosView tranferencia = new TranferenciaParaInvestimentosView(bancoDeDados, contaLogada);
                        tranferencia.transferir();
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                        formaInvestimento();
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
                formaInvestimento();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um numero.");
               formaInvestimento();
        }
        }


}

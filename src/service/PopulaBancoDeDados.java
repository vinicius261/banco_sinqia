package service;

import database.BancoDeDados;
import enums.TipoDeCliente;
import model.Cliente;

public class PopulaBancoDeDados {

    String dadosSimulados =     PESSOA_FISICA "+
                PESSOA_FISICA " +
                PESSOA_JURIDICA " +
                PESSOA_JURIDICA " +
               , PESSOA_FISICA " +
            "Augusto Simão 572.228.280-44 simao@gmail.com 09/11/1999 PESSOA_FISICA " +
            "Cicero Cançado 108.116.370-42 cancado@gmail.com 01/01/1998 PESSOA_FISICA " +
            "Joana Santana 080.002.810-40 santana@gmail.com 28/02/1958 PESSOA_FISICA " +
            "Paula Garcia 700.814.780-54 garcia@gmail.com 24/10/2002 PESSOA_FISICA " +
            "Juliano Jesus 794.912.310-90 jesus@gmail.com 14/04/1994 PESSOA_FISICA";

    public void cadastraContas(){
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



    }

}

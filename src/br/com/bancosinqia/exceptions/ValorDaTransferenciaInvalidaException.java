package br.com.bancosinqia.exceptions;

public class ValorDaTransferenciaInvalidaException extends RuntimeException{
    public ValorDaTransferenciaInvalidaException(String msg){
        super(msg);
    }
}

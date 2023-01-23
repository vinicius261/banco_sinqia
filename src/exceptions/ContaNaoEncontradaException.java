package exceptions;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String msg){
        super(msg);
    }
}

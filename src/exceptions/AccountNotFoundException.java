package exceptions;

public class AccountNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Esta conta não está cadastrada no sistema.";

    }
}

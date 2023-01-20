package exceptions;

public class UserNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Este e-mail não está cadastrado no sistema, Por favor digite um e-mail cadastrado:";

    }
}

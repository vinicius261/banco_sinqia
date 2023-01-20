package exceptions;

public class PasswordNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Senha inválida, por favor digite a senha cadastrada para seu e-mail:";

    }
}

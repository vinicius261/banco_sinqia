package controller;

import java.util.regex.Pattern;

public class ValidarFormatoSenhaController {
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(PASSWORD_REGEX);

    boolean senhaCorreta = false;

    public boolean validarSenha(String password) {
        // Valida uma senha
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            senhaCorreta = true;
        }
        return senhaCorreta;
    }
}

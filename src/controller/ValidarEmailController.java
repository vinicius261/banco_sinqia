package controller;

import database.BancoDeDados;
import interfaces.Validar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmailController implements Validar<String , Boolean> {

    private BancoDeDados bancoDeDados;
    public Boolean validar(String email) {
        boolean validacaoEmail = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                validacaoEmail = true;
            }
        }
        return validacaoEmail;
    }
}

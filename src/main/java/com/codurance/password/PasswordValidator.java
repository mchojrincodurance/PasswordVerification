package com.codurance.password;

import org.jetbrains.annotations.Contract;

public class PasswordValidator {
    public boolean isValid(String password) {
        return containsACapitalLetter(password) &&
                containsALowerCaseLetter(password) &&
                containsANumber(password) &&
                containsAnUnderscore(password)
                ;
    }

    @Contract(pure = true)
    private boolean containsAnUnderscore(String password) {
        return password.indexOf('_') > -1;
    }

    @Contract(pure = true)
    private boolean containsANumber(String password) {
        return password.matches(".*[1-9].*");
    }

    @Contract(pure = true)
    private boolean containsALowerCaseLetter(String password) {
        return password.matches(".*[a-z].*");
    }
    @Contract(pure = true)
    private boolean containsACapitalLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    public void addValidationRule(ValidationRule validationRule) {
        throw new UnsupportedOperationException("com.codurance.password.PasswordValidator::addValidationRule not implemented yet");
    }
}

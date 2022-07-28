package com.codurance.password;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class PasswordValidator {
    private ArrayList<ValidationRule> validationRules = new ArrayList<>();

    public boolean isValid(String password) {
        return containsACapitalLetter(password) &&
                containsALowerCaseLetter(password) &&
                containsANumber(password) &&
                containsAnUnderscore(password) &&
                hasAtLeastChars(password,8)
                ;
    }

    @Contract(pure = true)
    private boolean hasAtLeastChars(String password, int quantity) {
        return password.length() >= quantity;
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
        validationRules.add(validationRule);
    }
}

package com.codurance.password;

public class MinimumCapitalLettersValidation extends ValidationRule {
    private final int minCapitalLetters;

    public MinimumCapitalLettersValidation(int minCapitalLetters) {
        this.minCapitalLetters = minCapitalLetters;
    }

    public boolean isValid(String password) {
        return password.chars().filter(Character::isUpperCase).count() >= minCapitalLetters;
    }
}

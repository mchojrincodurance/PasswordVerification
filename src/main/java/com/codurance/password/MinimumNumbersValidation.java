package com.codurance.password;

public class MinimumNumbersValidation extends ValidationRule {
    private final int minNumbers;

    public MinimumNumbersValidation(int minNumbers) {
        super("Minimum numbers error");
        this.minNumbers = minNumbers;
    }

    public boolean isValid(String password) {
        return password.chars().filter(Character::isDigit).count() >= minNumbers;
    }
}

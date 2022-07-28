package com.codurance.password;

public class MinimumLowercaseLettersValidation extends ValidationRule {
    private final int minLowercaseLetters;

    public MinimumLowercaseLettersValidation(int minLowercaseLetters) {
        this.minLowercaseLetters = minLowercaseLetters;
    }

    public boolean isValid(String password) {
        return password.chars().filter(Character::isLowerCase).count() >= minLowercaseLetters;
    }
}

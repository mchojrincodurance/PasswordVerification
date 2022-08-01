package com.codurance.password;

public class MinimumLowercaseLettersValidation extends ValidationRule {
    private final int minLowercaseLetters;

    public MinimumLowercaseLettersValidation(int minLowercaseLetters) {
        super("Minimum lower case letters error");
        this.minLowercaseLetters = minLowercaseLetters;
    }

    public boolean isValid(String password) {
        return password.chars().filter(Character::isLowerCase).count() >= minLowercaseLetters;
    }
}

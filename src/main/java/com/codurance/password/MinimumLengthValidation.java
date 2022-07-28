package com.codurance.password;

public class MinimumLengthValidation extends ValidationRule {
    private final int minLength;

    public MinimumLengthValidation(int minLength) {
        this.minLength = minLength;
    }

    public boolean isValid(String s) {
        return s.length() >= minLength;
    }
}

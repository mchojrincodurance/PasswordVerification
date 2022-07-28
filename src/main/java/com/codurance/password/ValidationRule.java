package com.codurance.password;

public abstract class ValidationRule {
    private String errorMessage;

    public abstract boolean isValid(String password);

    public String getErrorMessage() {
        return errorMessage;
    }
}

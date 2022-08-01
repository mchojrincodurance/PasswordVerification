package com.codurance.password;

public abstract class ValidationRule {
    private final String errorMessage;

    public ValidationRule(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract boolean isValid(String password);

    public String getErrorMessage() {
        return errorMessage;
    }
}

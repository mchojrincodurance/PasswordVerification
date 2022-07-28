package com.codurance.password;

public abstract class ValidationRule {
    public abstract boolean isValid(String password);
}

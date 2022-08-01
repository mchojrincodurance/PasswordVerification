package com.codurance.password;

import java.util.ArrayList;

public class PasswordValidator {
    private final ArrayList<ValidationRule> validationRules = new ArrayList<>();
    private int maxAllowedFailures = 0;

    public boolean isValid(String password) {
        return getProblemsWith(password).size() <= maxAllowedFailures;
    }

    public void addValidationRule(ValidationRule validationRule) {
        validationRules.add(validationRule);
    }

    public ArrayList<String> getProblemsWith(String password) {
        ArrayList<String> errors = new ArrayList<>();

        for( ValidationRule rule : validationRules ) {
            if (!rule.isValid(password)) {
                errors.add(rule.getErrorMessage());
            }
        }

        return errors;
    }

    public void allowFailedValidations(int maxAllowedFailures) {
        this.maxAllowedFailures = maxAllowedFailures;
    }
}

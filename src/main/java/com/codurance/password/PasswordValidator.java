package com.codurance.password;

import java.util.ArrayList;

public class PasswordValidator {
    private final ArrayList<ValidationRule> validationRules = new ArrayList<>();

    public boolean isValid(String password) {
        return getProblemsWith(password).isEmpty();
    }

    public void addValidationRule(ValidationRule validationRule) {
        validationRules.add(validationRule);
    }

    public ArrayList<String> getProblemsWith(String password) {
        ArrayList<String> errors = new ArrayList<String>();

        for( ValidationRule rule : validationRules ) {
            if (!rule.isValid(password)) {
                errors.add(rule.getErrorMessage());
            }
        }

        return errors;
    }
}

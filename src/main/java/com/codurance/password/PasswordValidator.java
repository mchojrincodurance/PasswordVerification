package com.codurance.password;

import java.util.ArrayList;

public class PasswordValidator {
    private final ArrayList<ValidationRule> validationRules = new ArrayList<>();

    public boolean isValid(String password) {
        for (ValidationRule rule : validationRules) {
            if ( !rule.isValid(password) ) {

                return false;
            }
        }

        return true;
    }

    public void addValidationRule(ValidationRule validationRule) {
        validationRules.add(validationRule);
    }

    public ArrayList<String> getProblemsWith(String password) {
        return new ArrayList<String>();
    }
}

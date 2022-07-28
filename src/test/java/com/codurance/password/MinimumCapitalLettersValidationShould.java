package com.codurance.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCapitalLettersValidationShould {
    private final MinimumCapitalLettersValidation minimumCapitalLettersValidation = new MinimumCapitalLettersValidation(2);

    @Test
    public void reject_strings_that_dont_contain_capital_letters() {
        assertFalse (minimumCapitalLettersValidation.isValid("aab"));
    }

    @Test
    public void accept_strings_containing_at_least_one_capital_letter() {
        assertTrue(minimumCapitalLettersValidation.isValid("AA"));
    }
}
package com.codurance.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumbersValidationShould {
    private static final int MIN = 3;
    private final MinimumNumbersValidation minimumNumbersValidation = new MinimumNumbersValidation(MIN);

    @Test
    public void reject_strings_not_containing_at_least_minimum_numbers() {
        assertFalse(minimumNumbersValidation.isValid("A".repeat(MIN)));
    }

    @Test
    public void accept_strings_containing_at_least_minimum_numbers() {
        assertTrue(minimumNumbersValidation.isValid("1".repeat(MIN)));
    }
}
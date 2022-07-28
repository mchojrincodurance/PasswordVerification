package com.codurance.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLowercaseLettersValidationShould {
    public static final int MIN_LOWER_LETTERS = 4;
    private final MinimumLowercaseLettersValidation minimumLowercaseLettersValidation = new MinimumLowercaseLettersValidation(MIN_LOWER_LETTERS);

    @Test
    public void reject_strings_with_less_lower_case_letters_than_minimum() {
        assertFalse(minimumLowercaseLettersValidation.isValid("A".repeat(MIN_LOWER_LETTERS)));
    }

    @Test
    public void reject_strings_with_more_lower_case_letters_than_minimum() {
        assertTrue(minimumLowercaseLettersValidation.isValid("a".repeat(MIN_LOWER_LETTERS)));
    }
}
package com.codurance.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumUnderscoresValidationShould {
    public static final int MIN = 6;
    private final MinimumUnderscoresValidation minimumUnderscoresValidation = new MinimumUnderscoresValidation(MIN);

    @Test
    public void reject_strings_with_less_than_minimum_chars() {
        assertFalse(minimumUnderscoresValidation.isValid("1".repeat(MIN)));
    }

    @Test
    public void accept_strings_with_more_than_minimum_chars() {
        assertTrue(minimumUnderscoresValidation.isValid("_".repeat(MIN)));
    }

}
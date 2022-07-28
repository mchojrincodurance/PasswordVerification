package com.codurance.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinimumLengthValidationShould
{

    private final MinimumLengthValidation minimumLengthValidation = new MinimumLengthValidation(6);

    @Test
    public void reject_strings_with_less_than_minimum_chars() {
        assertFalse(minimumLengthValidation.isValid("12345"));
    }

    @Test
    public void accept_strings_with_more_than_minimum_chars() {
        assertTrue(minimumLengthValidation.isValid("123456"));
    }

}
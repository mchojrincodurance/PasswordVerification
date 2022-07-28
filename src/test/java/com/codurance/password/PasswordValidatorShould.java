package com.codurance.password;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordValidatorShould {
    public static final String ERROR = "Error";
    private final PasswordValidator passwordValidator = new PasswordValidator();
    @Mock
    ValidationRule validation;

    @ParameterizedTest
    @CsvSource({
            "1bC_efgh,Custom error",
    })
    public void return_errors_according_to_its_validation_rules(String password, String error) {
        when(validation.isValid(anyString())).thenReturn(false);
        doAnswer(invocation -> error).when(validation).getErrorMessage();

        passwordValidator.addValidationRule(validation);

        assertEquals(Arrays.asList(error), passwordValidator.getProblemsWith(password));
        verify(validation).isValid(eq(password));
    }

    @ParameterizedTest
    @CsvSource({
            "1bC_efgh,true",
            "abcsadsa,false",
    })
    public void recognize_as_valid_passwords_without_errors(String password, boolean isValid) {
        when(validation.isValid(anyString())).thenReturn(isValid);
        doAnswer(invocation -> ERROR).when(validation).getErrorMessage();

        assertEquals(isValid, passwordValidator.isValid(password));
    }
}

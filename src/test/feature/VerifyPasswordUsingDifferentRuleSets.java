import com.codurance.password.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyPasswordUsingDifferentRuleSets {
    /**
     * Given the password must have more than 8 characters in order to be valid
     * And the password must contain a capital letter in order to be valid
     * And the password must contain a lowercase letter in order to be valid
     * And the password must contain a number in order to be valid
     * And the password must contain an underscore in order to be valid
     * And I set the password to "1bC_efgh"
     * When I ask whether my password is valid
     * Then I should get false as a result
     */
    @ParameterizedTest
    @CsvSource({
            "1bC_efgh,",
            "1bc_efg,Minimum length error",
            "1bc_efgh,Minimum capital letters error",
            "1BC_EFGH,Minimum lower case letters error",
            "abC_efgh,Minimum numbers error",
            "1bCdefgh,Minimum underscores error"
    })
    public void should_use_the_first_ruleset_for_password_validation(String password, String expectedError) {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(8));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumNumbersValidation(1));
        passwordValidator.addValidationRule(new MinimumUnderscoresValidation(1));

        ArrayList<String> problems = passwordValidator.getProblemsWith(password);
        assertEquals(expectedError == null ? 0 : 1, problems.size());
        assertTrue(expectedError == null || problems.contains(expectedError));
    }

    /**
     * Given the password must have more than 6 characters in order to be valid
     * And the password must contain a capital letter in order to be valid
     * And the password must contain a lowercase letter in order to be valid
     * And the password must contain a number in order to be valid
     * And the password must contain an underscore in order to be valid
     * And I set the password to "1bCef6"
     * When I ask whether my password is valid
     * Then I should get false as a result
     */
    @ParameterizedTest
    @CsvSource({
            "1bC_ef,",
            "1bc_e,Minimum length error",
            "1bc_efgh,Minimum capital letters error",
            "1BC_EFGH,Minimum lower case letters error",
            "abC_efgh,Minimum numbers error",
    })
    public void should_use_the_second_ruleset_for_password_validation(String password, String expectedError) {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(6));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumNumbersValidation(1));

        ArrayList<String> problems = passwordValidator.getProblemsWith(password);
        assertEquals(expectedError == null ? 0 : 1, problems.size());
        assertTrue(expectedError == null || problems.contains(expectedError));
    }

    /**
     * Given the password must have more than 16 characters in order to be valid
     * And the password must contain a capital letter in order to be valid
     * And the password must contain a lowercase letter in order to be valid
     * And I set the password to "1bCef6"
     * When I ask whether my password is valid
     * Then I should get false as a result
     */
    @ParameterizedTest
    @CsvSource({
            "Ab_4567890123456,",
            "Ab_45678901234,Minimum length error",
            "bb_4567890123456,Minimum capital letters error",
            "AB_4567890123456,Minimum lower case letters error",
            "Abc4567890123456,Minimum underscores error",
    })
    public void should_use_the_third_ruleset_for_password_validation(String password, String expectedError) {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(16));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumUnderscoresValidation(1));

        ArrayList<String> problems = passwordValidator.getProblemsWith(password);
        assertEquals(expectedError == null ? 0 : 1, problems.size());
        assertTrue(expectedError == null || problems.contains(expectedError));
    }
}

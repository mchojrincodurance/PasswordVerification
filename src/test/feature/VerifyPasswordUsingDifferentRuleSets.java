import com.codurance.password.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void should_use_the_first_ruleset_for_password_validation() {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(8));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumNumbersValidation(1));
        passwordValidator.addValidationRule(new MinimumUnderscoresValidation(1));

        assertTrue(passwordValidator.isValid("1bC_efgh"));
        assertFalse(passwordValidator.isValid("1bC_efg"));
        assertFalse(passwordValidator.isValid("1bc_efgh"));
        assertFalse(passwordValidator.isValid("1BC_EFGH"));
        assertFalse(passwordValidator.isValid("abC_efgh"));
        assertFalse(passwordValidator.isValid("1bCdefgh"));
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
    @Test
    public void should_use_the_second_ruleset_for_password_validation() {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(6));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumNumbersValidation(1));

        assertTrue(passwordValidator.isValid("1bCef6"));
    }

    /**
     * Given the password must have more than 16 characters in order to be valid
     * And the password must contain a capital letter in order to be valid
     * And the password must contain a lowercase letter in order to be valid
     * And I set the password to "1bCef6"
     * When I ask whether my password is valid
     * Then I should get false as a result
     */
    @Test
    public void should_use_the_third_ruleset_for_password_validation() {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(16));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumUnderscoresValidation(1));

        assertTrue(passwordValidator.isValid("Ab_4567890123456"));
        assertFalse(passwordValidator.isValid("ab_456789012345"));
        assertFalse(passwordValidator.isValid("AB_4567890123456"));
        assertFalse(passwordValidator.isValid("Abc4567890123456"));
    }
}

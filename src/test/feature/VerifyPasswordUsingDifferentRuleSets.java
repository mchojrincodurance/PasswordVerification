import com.codurance.password.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void should_use_the_ruleset_for_password_validation() {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addValidationRule(new MinimumLengthValidation(8));
        passwordValidator.addValidationRule(new MinimumCapitalLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumLowercaseLettersValidation(1));
        passwordValidator.addValidationRule(new MinimumNumbersValidation(1));
        passwordValidator.addValidationRule(new MinimumUnderscoresValidation(1));

        assertEquals(true, passwordValidator.isValid("1bC_efgh"));
    }
}

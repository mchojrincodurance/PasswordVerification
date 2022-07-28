import com.codurance.password.PasswordValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorShould {
    private final PasswordValidator passwordValidator = new PasswordValidator();

    @ParameterizedTest
    @CsvSource({
            "1_34567, false",
            "1bC_efgh, true",
            "a_cdefgh, false",
            "A_CDEFGH, false",
            "a_cDefgh, false",
            "aBc1efgh, false",
    })

    public void detect_incorrect_passwords(String password, boolean isValid) {
        assertEquals(isValid, passwordValidator.isValid(password));
    }
}

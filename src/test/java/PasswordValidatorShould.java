import com.codurance.password.PasswordValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorShould {
    private final PasswordValidator passwordValidator = new PasswordValidator();

    @ParameterizedTest
    @CsvSource({
            "1bC_efgh, true",
            "1bC_efg, false",
            "1bc_efgh, false",
            "1BC_EFGH, false",
            "AbC_efgh, false",
            "1bCdefgh, false",
    })

    public void detect_incorrect_passwords(String password, boolean isValid) {
        assertEquals(isValid, passwordValidator.isValid(password));
    }
}

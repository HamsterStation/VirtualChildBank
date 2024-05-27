import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code registerTest} class contains unit tests for the password validation method in the {@link StringUtil} class.
 * This class uses JUnit 5 for testing.
 */
public class registerTest {
    @Test
    public void registerTestValidNull() {
        assertFalse(StringUtil.PasswordisValid(""));
        assertFalse(StringUtil.PasswordisValid(" "));
    }
    @Test
    public void registerTestValidLength() {
        assertFalse(StringUtil.PasswordisValid("ab12"));
        assertFalse(StringUtil.PasswordisValid("avgae1212411"));
    }
    @Test
    public void registerTestValidLN() {
        assertFalse(StringUtil.PasswordisValid("!@#$%^*"));
    }
    @Test
    public void registerTestValidLetterAndNumber() {
        assertFalse(StringUtil.PasswordisValid("abcde"));
        assertFalse(StringUtil.PasswordisValid("12345"));
    }
    @Test
    public void registerTestValidSuccess() {
        assertTrue(StringUtil.PasswordisValid("abcd2"));
        assertTrue(StringUtil.PasswordisValid("123EDCDA"));
    }
}

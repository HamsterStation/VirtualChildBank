import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code loginTest} class contains unit tests for the authentication method in the {@link UserService} class.
 * This class uses JUnit 5 for testing.
 */

public class loginTest {
    @BeforeAll
    public static void setup() {
        // initialize UserService
        new UserService();
    }
    @Test
    public void loginTestValidNull() {
        assertFalse(UserService.authenticate("asdadsda",""));
        assertFalse(UserService.authenticate("","asd1234"));
    }
    @Test
    public void loginTestValidMismatch() {
        assertFalse(UserService.authenticate("adminTest1","aaaaaaaaaa"));
        assertFalse(UserService.authenticate("aaaaaaaaaa","abc123"));
    }

    @Test
    public void loginTestValidSuccess() {
        assertTrue(UserService.authenticate("adminTest1","abc123"));
        assertTrue(UserService.authenticate("aaaaaaaaaa","aaaaaaaaaa"));
    }
}

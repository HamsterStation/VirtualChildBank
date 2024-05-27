/**
 * The {@code StringUtil} class provides utility methods for validating passwords, account IDs, and saving goals.
 */
public class StringUtil {

    /**
     * Validates a password based on specific criteria.
     * The password must be between 5 and 9 characters long, contain only letters and digits,
     * and include at least one letter and one digit.
     *
     * @param password the password to validate
     * @return {@code true} if the password is valid, {@code false} otherwise
     */
    public static boolean PasswordisValid(String password) {
        // Check the length of the password
        if (password == null || password.length() < 5 || password.length() > 9) {
            return false;
        }

        // Check for only letters and digits
        if (!password.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Check for at least one letter and one digit
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                return true;
            }
        }

        return false;
    }

    /**
     * Validates an account ID.
     * The account ID must be exactly 16 characters long.
     *
     * @param accountId the account ID to validate
     * @return {@code true} if the account ID is valid, {@code false} otherwise
     */
    public static boolean accountIdisValid(String accountId) {
        return accountId != null && accountId.length() == 16;
    }

    /**
     * Validates a saving goal.
     * The goal must be a non-empty string consisting only of digits.
     *
     * @param goal the saving goal to validate
     * @return {@code true} if the saving goal is valid, {@code false} otherwise
     */
    public static boolean savingGoalisValid(String goal) {
        return goal != null && !goal.isEmpty() && goal.matches("\\d+");
    }
}

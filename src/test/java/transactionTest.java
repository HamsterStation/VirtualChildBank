import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code transactionTest} class contains unit tests for the {@link Transaction} class.
 * This class uses JUnit 5 for testing.
 */
public class transactionTest {

    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        // Initialize a Transaction object
        transaction = new Transaction("9999999999999999", 100.0, "deposit");
    }

    @Test
    public void testTransactionConstructor() {
        String accountId = "9999999999999999";
        double amount = 100.0;
        String type = "deposit";

        Transaction transaction = new Transaction(accountId, amount, type);

        assertEquals(accountId, transaction.getAccountId());
        assertEquals(amount, transaction.getAmount());
        assertEquals(type, transaction.getType());
        assertNotNull(transaction.getTimestamp());
    }

    @Test
    public void testEmptyConstructor() {
        Transaction transaction = new Transaction();

        assertNull(transaction.getAccountId());
        assertEquals(0.0, transaction.getAmount());
        assertNull(transaction.getType());
        assertNull(transaction.getTimestamp());
    }

    @Test
    public void testSetAccountId() {
        String newAccountId = "newAccount123";
        transaction.setAccountId(newAccountId);

        assertEquals(newAccountId, transaction.getAccountId());
    }

    @Test
    public void testSetAmount() {
        double newAmount = 200.0;
        transaction.setAmount(newAmount);

        assertEquals(newAmount, transaction.getAmount());
    }

    @Test
    public void testSetTimestamp() {
        LocalDateTime newTimestamp = LocalDateTime.of(2024, 1, 1, 0, 0);
        transaction.setTimestamp(newTimestamp);

        assertEquals(newTimestamp, transaction.getTimestamp());
    }

    @Test
    public void testSetType() {
        String newType = "withdraw";
        transaction.setType(newType);

        assertEquals(newType, transaction.getType());
    }
}

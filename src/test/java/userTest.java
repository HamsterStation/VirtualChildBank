import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code UserTest} class contains unit tests for the {@link User} class.
 * This class uses JUnit 5 for testing.
 */
class userTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testUser1", "pw1234");

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("1356523125643821", "saving", 100.0));
        accounts.add(new Account("9878765765676762", "current", 200.0));
        user.setAccounts(accounts);

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", 50.0));
        tasks.add(new Task("Task2", 75.0));
        user.setTasks(tasks);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("1356523125643821", 50.0, "deposit"));
        transactions.add(new Transaction("9878765765676762", 25.0, "withdraw"));
        user.setTransactions(transactions);

        user.calculateTotalBalance();
    }

    @Test
    void testGetUsername() {
        assertEquals("testUser1", user.getUsername());
    }

    @Test
    void testSetUsername() {
        user.setUsername("testUser2");
        assertEquals("testUser2", user.getUsername());
    }

    @Test
    void testGetPassword() {
        assertEquals("pw1234", user.getPassword());
    }

    @Test
    void testSetPassword() {
        user.setPassword("1234pw");
        assertEquals("1234pw", user.getPassword());
    }

    @Test
    void testGetAccounts() {
        assertEquals(2, user.getAccounts().size());
    }

    @Test
    void testSetAccounts() {
        List<Account> newAccounts = new ArrayList<>();
        newAccounts.add(new Account("7676567629903454", "saving", 150.0));
        user.setAccounts(newAccounts);
        assertEquals(1, user.getAccounts().size());
        assertEquals("7676567629903454", user.getAccounts().get(0).getAccountId());
    }

    @Test
    void testGetTasks() {
        assertEquals(2, user.getTasks().size());
    }

    @Test
    void testSetTasks() {
        List<Task> newTasks = new ArrayList<>();
        newTasks.add(new Task("Task3", 100.0));
        user.setTasks(newTasks);
        assertEquals(1, user.getTasks().size());
        assertEquals("Task3", user.getTasks().get(0).getTaskContent());
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(300.0, user.getTotalBalance());
    }

    @Test
    void testSetTotalBalance() {
        user.setTotalBalance(400.0);
        assertEquals(400.0, user.getTotalBalance());
    }

    @Test
    void testCalculateTotalBalance() {
        user.calculateTotalBalance();
        assertEquals(300.0, user.getTotalBalance());
    }

    @Test
    void testGetTransactions() {
        assertEquals(2, user.getTransactions().size());
    }

    @Test
    void testSetTransactions() {
        List<Transaction> newTransactions = new ArrayList<>();
        newTransactions.add(new Transaction("7676567629903454", 75.0, "deposit"));
        user.setTransactions(newTransactions);
        assertEquals(1, user.getTransactions().size());
        assertEquals("7676567629903454", user.getTransactions().get(0).getAccountId());
    }

    @Test
    void testAddTransaction() {
        user.addTransaction(new Transaction("7676567629903454", 100.0, "withdraw"));
        assertEquals(3, user.getTransactions().size());
    }
}

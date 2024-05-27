import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code TaskTest} class contains unit tests for the {@link Task} class.
 * This class uses JUnit 5 for testing.
 */

class taskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        // Initialize a Transaction object
        task = new Task("Complete the task", 100.0);
    }

    @Test
    void testTaskConstructor() {
        assertEquals("Complete the task", task.getTaskContent());
        assertEquals(100.0, task.getTaskPrice());
    }

    @Test
    void testEmptyConstructor() {
        Task task = new Task();

        assertNull(task.getTaskContent());
        assertEquals(task.getTaskPrice(), 0.0);
    }

    @Test
    void testSetTaskContent() {
        String newTaskContent = "Updated task content";
        task.setTaskContent(newTaskContent);

        assertEquals(newTaskContent, task.getTaskContent());
    }

    @Test
    void testSetTaskPrice() {
        double newTaskPrice = 150.0;
        task.setTaskPrice(newTaskPrice);

        assertEquals(newTaskPrice, task.getTaskPrice());
    }
}

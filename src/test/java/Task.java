/**
 * The {@code Task} class represents a task with content and a price.
 * It includes methods to get and set the task content and price.
 */
public class Task {
    private String taskContent;
    private double taskPrice;

    /**
     * Default constructor.
     * Initializes a new instance of the {@code Task} class with default values.
     */
    public Task() {}

    /**
     * Initializes a new instance of the {@code Task} class with the specified content and price.
     *
     * @param taskContent the content of the task
     * @param taskPrice the price of the task
     */
    public Task(String taskContent, double taskPrice) {
        this.taskContent = taskContent;
        this.taskPrice = taskPrice;
    }

    /**
     * Gets the content of the task.
     *
     * @return the content of the task
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * Sets the content of the task.
     *
     * @param taskContent the new content of the task
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     * Gets the price of the task.
     *
     * @return the price of the task
     */
    public double getTaskPrice() {
        return taskPrice;
    }

    /**
     * Sets the price of the task.
     *
     * @param taskPrice the new price of the task
     */
    public void setTaskPrice(double taskPrice) {
        this.taskPrice = taskPrice;
    }
}

import java.time.LocalDateTime;

/**
 * The {@code Transaction} class represents a financial transaction.
 * It includes details such as the account ID, amount, timestamp, and type of the transaction.
 */
public class Transaction {
    private String accountId; // The account ID associated with the transaction
    private double amount; // The amount of the transaction
    private LocalDateTime timestamp; // The timestamp of the transaction
    private String type; // The type of the transaction, such as "deposit" or "withdraw"

    /**
     * Constructs a new {@code Transaction} with the specified account ID, amount, and type.
     * The timestamp is set to the current date and time.
     *
     * @param accountId the account ID associated with the transaction
     * @param amount the amount of the transaction
     * @param type the type of the transaction, such as "deposit" or "withdraw"
     */
    public Transaction(String accountId, double amount, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Set the timestamp to the current date and time
        this.type = type;
    }

    /**
     * Default constructor.
     * Initializes a new instance of the {@code Transaction} class with default values.
     */
    public Transaction() {
    }

    /**
     * Gets the account ID associated with the transaction.
     *
     * @return the account ID associated with the transaction
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the account ID associated with the transaction.
     *
     * @param accountId the account ID to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the amount of the transaction.
     *
     * @return the amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the transaction.
     *
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the timestamp of the transaction.
     *
     * @return the timestamp of the transaction
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the transaction.
     *
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the type of the transaction.
     *
     * @return the type of the transaction
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the transaction.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}

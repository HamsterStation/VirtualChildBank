/**
 * The {@code Account} class represents a bank account with an ID, type, and balance.
 * It provides methods to access and modify these attributes.
 */
public class Account {
    private String accountId;
    private String accountType;  // Account type, e.g., "saving" or "current"
    private double balance;

    /**
     * Default constructor for {@code Account}.
     */
    public Account() {
    }

    /**
     * Constructs an {@code Account} with the specified account ID, type, and balance.
     *
     * @param accountId   the ID of the account
     * @param accountType the type of the account
     * @param balance     the balance of the account
     */
    public Account(String accountId, String accountType, double balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    /**
     * Returns the account ID.
     *
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the account ID.
     *
     * @param accountId the new account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Returns the account type.
     *
     * @return the account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type.
     *
     * @param accountType the new account type
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Returns the account balance.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the account balance.
     *
     * @param balance the new account balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

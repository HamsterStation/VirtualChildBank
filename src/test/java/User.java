import java.util.ArrayList;
import java.util.List;

/**
 * The {@code User} class represents a user in the system.
 */
public class User {
    private String username;
    private String password;
    private String goal;
    private List<Account> accounts;
    private List<Task> tasks;
    private double totalBalance;
    private List<Transaction> transactions;

    /**
     * Constructs a new user with the given username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
        this.goal = "";
        this.tasks = new ArrayList<>();
        this.totalBalance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Constructs a new user with the specified fields.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param accounts the list of accounts associated with the user
     * @param goal the user's savings goal
     * @param tasks the list of tasks associated with the user
     * @param totalBalance the total balance across all accounts
     * @param transactions the list of transactions associated with the user
     */
    public User(String username, String password, List<Account> accounts, String goal, List<Task> tasks, Double totalBalance, List<Transaction> transactions) {
        this.username = username;
        this.password = password;
        this.accounts = accounts != null ? new ArrayList<>(accounts) : new ArrayList<>();
        this.goal = goal;
        this.tasks = tasks != null ? new ArrayList<>(tasks) : new ArrayList<>();
        this.totalBalance = totalBalance != null ? totalBalance : 0.0;
        this.transactions = transactions != null ? new ArrayList<>(transactions) : new ArrayList<>();
        calculateTotalBalance();  // Initialize total balance
    }

    /**
     * Gets the list of transactions associated with the user.
     *
     * @return the list of transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets the list of transactions associated with the user.
     *
     * @param transactions the list of transactions to set
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Adds a transaction to the list of transactions associated with the user.
     *
     * @param transaction the transaction to add
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Gets the user's savings goal.
     *
     * @return the savings goal
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Sets the user's savings goal.
     *
     * @param goal the savings goal to set
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * Gets the list of accounts associated with the user.
     *
     * @return the list of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets the list of accounts associated with the user.
     *
     * @param accounts the list of accounts to set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Adds an account to the list of accounts associated with the user.
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Gets the list of tasks associated with the user.
     *
     * @return the list of tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets the list of tasks associated with the user.
     *
     * @param tasks the list of tasks to set
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets the total balance across all accounts.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * Sets the total balance across all accounts.
     *
     * @param totalBalance the total balance to set
     */
    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * Calculates and updates the total balance across all accounts.
     */
    public void calculateTotalBalance() {
        totalBalance = 0.0;  // Reset total balance
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
    }
}

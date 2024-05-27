import java.util.List;

/**
 * The {@code UserService} class provides services for user management,
 * including authentication, user registration, and user updates.
 */
public class UserService {
    private static UserDao userDao;
    private static User currentUser; // Static variable to store the current user

    /**
     * Default constructor. Initializes the {@code UserDao}.
     */
    public UserService() {
        this.userDao = new UserDao(); // Ensure UserDao is properly initialized
    }

    /**
     * Constructor with dependency injection for {@code UserDao}.
     *
     * @param userDao the {@code UserDao} to use for data access
     */
    public UserService(UserDao userDao) {
        this.userDao = userDao; // Inject UserDao through constructor
    }

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return {@code true} if the user is authenticated successfully, {@code false} otherwise
     */
    public static boolean authenticate(String username, String password) {
        List<User> users = userDao.getUsersFromJson();
        if (users == null) {
            return false;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user; // Set the current user upon successful login
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the user information and recalculates the total balance.
     *
     * @param user the user to update
     */
    public void updateUserAndRecalculateBalance(User user) {
        user.calculateTotalBalance(); // Recalculate total balance
        userDao.saveUser(user); // Save the updated user information
    }

    /**
     * Registers a new user with the provided username and password.
     *
     * @param username the username of the new user
     * @param password the password of the new user
     */
    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userDao.addUser(user);
    }

    /**
     * Updates the user information.
     *
     * @param user the user to update
     */
    public void updateUser(User user) {
        userDao.saveUser(user); // Use the saveUser method of UserDao to update user data
    }

    /**
     * Gets the current authenticated user.
     *
     * @return the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the current authenticated user.
     *
     * @param user the user to set as the current user
     */
    public void setCurrentUser(User user) {
        currentUser = user;
    }
}

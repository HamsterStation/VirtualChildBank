import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code UserDao} class provides methods for accessing user data stored in JSON format.
 */
public class UserDao {

    private static final String JSON_FILE_PATH = "E:\\java code\\VirtualChildBank\\src\\main\\resources\\json\\users.json";

    /**
     * Retrieves users from a JSON file.
     *
     * @return a list of users parsed from the JSON file
     */
    public List<User> getUsersFromJson() {
        try {
            Path path = Paths.get(JSON_FILE_PATH);
            if (Files.exists(path)) {
                String json = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                List<User> users = JSON.parseObject(json, new TypeReference<List<User>>() {});
                if (users != null) {
                    for (User user : users) {
                        System.out.println("User: " + user.getUsername() + ", Accounts: " + user.getAccounts().size());
                        for (Account account : user.getAccounts()) {
                            System.out.println("Account ID: " + account.getAccountId() + ", Type: " + account.getAccountType() + ", Balance: " + account.getBalance());
                        }
                    }
                }
                return users;
            } else {
                System.out.println("File not found: " + JSON_FILE_PATH);
                return new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Adds a new user to the JSON file.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        List<User> users = getUsersFromJson();
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
        saveUsersToJson(users);
    }

    /**
     * Saves an updated user to the JSON file.
     *
     * @param updatedUser the updated user
     */
    public void saveUser(User updatedUser) {
        List<User> users = getUsersFromJson();
        if (users == null) {
            users = new ArrayList<>();
        }

        int userIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(updatedUser.getUsername())) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            users.set(userIndex, updatedUser);
        } else {
            users.add(updatedUser);
        }

        saveUsersToJson(users);
    }

    /**
     * Saves the list of users to the JSON file.
     *
     * @param users the list of users to save
     */
    private void saveUsersToJson(List<User> users) {
        try {
            Path path = Paths.get(JSON_FILE_PATH);
            String updatedJson = JSON.toJSONString(users, SerializerFeature.PrettyFormat);
            Files.write(path, updatedJson.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.VirtualChildBank.test;

import com.VirtualChildBank.dao.UserDao;
import com.VirtualChildBank.model.User;
import com.VirtualChildBank.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code UserServiceTest} class contains unit tests for the {@link UserService} class.
 * This class uses JUnit 5 for testing.
 */

class UserServiceTest {

    private UserService userService;
    private List<User> testUsers;

    @BeforeEach
    void setUp() {
        // initialize test user data
        testUsers = new ArrayList<>();
        testUsers.add(new User("user1", "password1"));
        testUsers.add(new User("user2", "password2"));

        // create a mock UserDao
        UserDao mockUserDao = new UserDao() {
            @Override
            public List<User> getUsersFromJson() {
                return testUsers;
            }

            @Override
            public void saveUser(User user) {
                int index = -1;
                for (int i = 0; i < testUsers.size(); i++) {
                    if (testUsers.get(i).getUsername().equals(user.getUsername())) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    testUsers.set(index, user);
                } else {
                    testUsers.add(user);
                }
            }

            @Override
            public void addUser(User user) {
                testUsers.add(user);
            }
        };

        // initialize userService, inject mock UserDao
        userService = new UserService(mockUserDao);
    }

    @Test
    void testAuthenticate() {
        // test valid login
        assertTrue(userService.authenticate("user1", "password1"));

        // test invalid login
        assertFalse(userService.authenticate("user1", "password2"));
    }

    @Test
    void testRegisterUser() {
        // register new user
        userService.registerUser("user3", "password3");
        assertTrue(userService.authenticate("user3", "password3"));

        // make sure the new user exists in the user list
        User newUser = null;
        for (User user : testUsers) {
            if (user.getUsername().equals("user3")) {
                newUser = user;
                break;
            }
        }
        assertNotNull(newUser);
        assertEquals("password3", newUser.getPassword());
    }

    @Test
    void testUpdateUserAndRecalculateBalance() {
        // update user information and recalculate balance
        User user = testUsers.get(0);
        user.setPassword("newpw1");
        userService.updateUserAndRecalculateBalance(user);

        // verify updated user information
        assertTrue(userService.authenticate("user1", "newpw1"));
    }

    @Test
    void testGetCurrentUser() {
        // set and get the current user
        User user = testUsers.get(0);
        userService.setCurrentUser(user);
        assertEquals(user, userService.getCurrentUser());
    }
}

package com.VirtualChildBank.test;

import com.VirtualChildBank.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    @BeforeAll
    public static void setup() {
        // 初始化 UserService
        new UserService();
    }

    @Test
    public void loginTestValidNull() {
        assertFalse(UserService.authenticate("asdadsda",""));
        assertFalse(UserService.authenticate("","asd1234"));
    }

    @Test
    public void loginTestValidMismatch() {
        assertFalse(UserService.authenticate("adminTest1","aaaaaaaaaa"));
        assertFalse(UserService.authenticate("aaaaaaaaaa","abc123"));
    }

    @Test
    public void loginTestValidCorrect() {
        assertTrue(UserService.authenticate("adminTest1","abc123"));
        assertTrue(UserService.authenticate("aaaaaaaaaa","aaaaaaaaaa"));
    }
}

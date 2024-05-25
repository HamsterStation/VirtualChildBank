package com.VirtualChildBank.test;

import com.VirtualChildBank.util.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class registerTest {
    @Test
    public void registerTestValidNull() {
        assertFalse(StringUtil.PasswordisValid(""));
        assertFalse(StringUtil.PasswordisValid(" "));
    }

    @Test
    public void registerTestValidLength() {
        assertFalse(StringUtil.PasswordisValid("ab12"));
        assertFalse(StringUtil.PasswordisValid("avgae1212411"));
    }

    @Test
    public void registerTestValidLN() {
        assertFalse(StringUtil.PasswordisValid("!@#$%^*"));
    }

    @Test
    public void registerTestValidLetterAndNumber() {
        assertFalse(StringUtil.PasswordisValid("abcde"));
        assertFalse(StringUtil.PasswordisValid("12345"));
    }

    @Test
    public void registerTestValidCorrect() {
        assertTrue(StringUtil.PasswordisValid("abcd2"));
        assertTrue(StringUtil.PasswordisValid("123EDCDA"));
    }
}

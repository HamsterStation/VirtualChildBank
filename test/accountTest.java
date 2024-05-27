package com.VirtualChildBank.test;

import com.VirtualChildBank.util.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code accountTest} class contains unit tests for the {@link StringUtil#accountIdisValid(String)} method.
 * This class uses JUnit 5 for testing.
 */

public class accountTest {
    @Test
    public void accountTestValidNull() {
        assertFalse(StringUtil.accountIdisValid(null));
    }
    @Test
    public void accountTestValidLength() {
        assertFalse(StringUtil.accountIdisValid("314351497"));
    }
    @Test
    public void accountTestValidSuccess() {
        assertTrue(StringUtil.accountIdisValid("9999999999999999"));
    }
}

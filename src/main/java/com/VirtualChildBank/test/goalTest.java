package com.VirtualChildBank.test;

import com.VirtualChildBank.util.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code goalTest} class contains unit tests for the {@link StringUtil#savingGoalisValid(String)} method.
 * This class uses JUnit 5 for testing.
 */

public class goalTest {
    @Test
    public void goalTestValidNull() {
        assertFalse(StringUtil.savingGoalisValid(null));
    }
    @Test
    public void goalTestValidEmpty() {
        assertFalse(StringUtil.savingGoalisValid(""));
    }
    @Test
    public void goalTestValidNoNumber() {
        assertFalse(StringUtil.savingGoalisValid("gaidawc"));
    }
    @Test
    public void goalTestValidSuccess() {
        assertTrue(StringUtil.savingGoalisValid("500"));
    }
}

package com.VirtualChildBank.test;

import com.VirtualChildBank.util.StringUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class accountTest {
    @Test
    public void accountTestValidNull() {
        assertFalse(StringUtil.accountIdisValid(""));
    }

    @Test
    public void accountTestValidLength() {
        assertFalse(StringUtil.accountIdisValid("9999999999999999999999"));
        assertFalse(StringUtil.accountIdisValid("9999999999"));
    }

    @Test
    public void accountTestValidCorrect() {
        assertTrue(StringUtil.accountIdisValid("9999999999999999"));
    }
}

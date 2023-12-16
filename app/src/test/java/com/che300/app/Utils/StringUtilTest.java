package com.che300.app.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName StringUtilTest.java
 * @Description TODO
 * @createTime 2023/12/14 15:22
 */
class StringUtilTest {

    @Test
    void isMobile_validPhoneNumber_returnsTrue() {
        String phoneNumber = "13888888888";
        assertTrue(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_invalidPhoneNumber_returnsFalse() {
        String phoneNumber = "110";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_nullPhoneNumber_returnsFalse() {
        String phoneNumber = null;
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_emptyPhoneNumber_returnsFalse() {
        String phoneNumber = "";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_whitespacePhoneNumber_returnsFalse() {
        String phoneNumber = " ";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_internationalPhoneNumber_returnsFalse() {
        String phoneNumber = "+123-456-7890";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_tooShortPhoneNumber_returnsFalse() {
        String phoneNumber = "12345";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }

    @Test
    void isMobile_tooLongPhoneNumber_returnsFalse() {
        String phoneNumber = "12345678901";
        assertFalse(StringUtil.isMobile(phoneNumber));
    }


    @Test
    public void test_isEmpty_withEmptyString_shouldReturnTrue() {
        String str = "";
        boolean result = StringUtil.isEmpty(str);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_isEmpty_withNonEmptyString_shouldReturnFalse() {
        String str = "test";
        boolean result = StringUtil.isEmpty(str);
        Assertions.assertFalse(result);
    }

}
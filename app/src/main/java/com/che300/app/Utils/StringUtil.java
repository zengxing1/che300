package com.che300.app.Utils;

import javafx.scene.input.Mnemonic;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName StringUtil.java
 * @Description TODO
 * @createTime 2023/12/14 14:01
 */
public class StringUtil {
    public static boolean isMobile(String mobile) {
        if (mobile == null) return false;
        return mobile.matches("^1[3456789]\\d{9}$");
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}

package com.sunsheng.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * uuid生成工具
 */
public class UUIDUtil {
    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String get256Code() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s.append(getUUID());
        }
        return s.toString();
    }

    public String getAuthorizationCode() {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int k = random.nextInt(62);
            tmp.append(s.charAt(k));
        }
        return tmp.toString();
    }
}

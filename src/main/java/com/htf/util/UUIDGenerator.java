package com.htf.util;

import java.util.UUID;

/**
 * UUID生成器
 * Created by PC-FENG on 2017/8/16.
 */
public class UUIDGenerator {
    public static String creatUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        String str = UUIDGenerator.creatUUID();
        System.out.println(str);
    }
}

package com.baidu.hi.ai.client;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        Long l1 = 0L;
        Long l2 = 0L;
        System.out.println(l1 == l2);
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}

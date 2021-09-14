package com.xing;

import com.xing.leetcode.剑指offer.CQueue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Mystery
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println(new String(decoder.decode("aHR0cHM6Ly9pbWd0dS5jb20vaS9oQllwRzk=")));
    }

    public static void t1() throws InterruptedException {
        synchronized (Test.class) {
            Thread.sleep(400L);
            t2();
            System.out.println(1);
        }
    }

    public static void t2() throws InterruptedException {
        synchronized (First.class) {
            Thread.sleep(400L);
            t1();
            System.out.println(2);
        }
    }

}

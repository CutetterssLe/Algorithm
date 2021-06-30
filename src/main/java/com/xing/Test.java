package com.xing;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mystery
 */
public class Test {

    public static void main(String[] args) {
        cc();
    }

    private static synchronized int cc() {
        return 0;
    }
}

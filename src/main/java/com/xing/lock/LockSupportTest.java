package com.xing.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;

/**
 * @author Mystery
 * 交替打印ABC
 */
public class LockSupportTest {
    public static void main(String[] args) {
        LockSupportTest lock = new LockSupportTest();
        Consumer<String> consumer = str -> {
            while (true) {
                LockSupport.park(lock);
                if (Thread.currentThread().isInterrupted()) {
                    throw new RuntimeException("`12");
                }
                System.out.println(Thread.currentThread().getName() + ":" + str);
            }
        };
        Thread t1 = new Thread(() -> {
            consumer.accept("A");
        },"T1");
        Thread t2 =new Thread(() -> {
            consumer.accept("B");
        },"T2");
        Thread t3 =new Thread(() -> {
            consumer.accept("C");
        },"T3");
        Thread td =new Thread(() -> {
            int i = 0;
            while (true) {
                if (i % 3 == 0) {
                    LockSupport.unpark(t1);
                } else if (i % 3 == 1) {
                    LockSupport.unpark(t2);
                } else  {
                    LockSupport.unpark(t3);
                }
                i++;
                try {

                    Thread.sleep(500L);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
        t3.start();
        td.start();
    }
}

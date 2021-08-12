package com.xing.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;

/**
 * @author Mystery
 * 交替打印ABC
 */
public class LockSupportTest {
    static final Mutex mutex = new Mutex();
    public static void main(String[] args) {

//        LockSupportTest lock = new LockSupportTest();
        Consumer<String> consumer = str -> {
            while (true) {
//                LockSupport.park(lock);
                mutex.lock();
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
                mutex.unlock();
                i++;
                try {

                    Thread.sleep(1500L);
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

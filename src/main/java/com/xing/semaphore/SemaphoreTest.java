package com.xing.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Mystery
 * @date 2021-04-25
 */
public class SemaphoreTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10,false);

        for (int i = 0; i < 100; i++) {
            new Thread(() ->

                {
                    System.out.println("欢迎" + Thread.currentThread().getName() + "来到停车场");
                    if (semaphore.availablePermits() == 0) {
                        System.out.println("车位不足，请等待");
                    }
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "进入");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "驶出");
                        semaphore.release();
                        if (semaphore.availablePermits() >= 10) {
                            System.err.println("太多了--------------------------");
                        }
                    } catch (Exception e) {
                        System.err.println("发生异常了");
                    }

            }, i + "号车").start();
        }
    }
}

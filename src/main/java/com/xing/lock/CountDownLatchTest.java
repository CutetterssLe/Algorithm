package com.xing.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mystery
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(finalI + "号运动员就位");
                try {
                    countDownLatch.await();
                    System.out.println(finalI +"号开始跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(3000);
        countDownLatch.countDown();
        System.out.println("结束");
    }
}

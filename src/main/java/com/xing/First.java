package com.xing;

import com.xing.lock.CountDownLatchTest;
import com.xing.lock.LockSupportTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Mystery
 */
public class First {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
//        Set<Map.Entry<String, Object>> set = map.entrySet();
//        for (Map.Entry<String, Object> entry : set) {
//            if (entry.getKey().equals("1")) {
//                map.remove(entry.getKey());
//            }
//        }
//        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
//        if (iterator.hasNext()) {
//            Map.Entry<String, Object> next = iterator.next();
//            if (next.getKey().equals("1")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(map);
//        Test test = Test.buildTest(new First());
//        System.out.println(test);
//        System.out.println(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")))
//                .minusHours(1));
//
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
//        arrayBlockingQueue.offer("1");
//        arrayBlockingQueue.offer("2");
//        arrayBlockingQueue.offer("3");
//        arrayBlockingQueue.offer("4");
//        System.out.println(arrayBlockingQueue);
//        CountDownLatchTest c = new CountDownLatchTest();
//        LockSupportTest t = new LockSupportTest();
//        ObjectSize<CountDownLatchTest, LockSupportTest> size = new ObjectSize<>(c, t);
//        CountDownLatchTest e = size.getE();
//        LockSupportTest t1 = size.getT();
//        System.out.println(e == c);
//        System.out.println(t == t1);
        LocalDate now = LocalDate.now();
        System.out.println(LocalDateTime.of(now, LocalTime.MAX));
//        System.out.println(now.getMonth());
//        System.out.println(now.getYear());
//        System.out.println(now.getMonthValue());
//        System.out.println(now.getDayOfMonth());
//        System.out.println(LocalDate.of(now.getYear(), now.getMonth(), 1));
    }

    private static int s(int i) {
        return i + 1;
    }

    private static int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

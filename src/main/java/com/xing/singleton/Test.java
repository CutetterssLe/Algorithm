package com.xing.singleton;

import java.util.ArrayList;

/**
 * @author Mystery
 */
public class Test {
    public static void main(String[] args) throws Exception{
//        Class<?> clazz = Class.forName("com.xing.singleton.SingletonObj");
//        Object o = clazz.newInstance();
//        System.out.println(o);
//        while (true);
        int c = 0;
        boolean f = true;
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            try {
                objects.get(-1);
            } catch (Exception e) {
                // JVM fast throw 机制，同一位置抛错大概6700次，就会不显示堆栈信息
                //报错异常：：java.lang.ArrayIndexOutOfBoundsException: -1, 堆栈长度：：3
                //报错异常：：java.lang.ArrayIndexOutOfBoundsException, 堆栈长度：：0
                c++;
                int length = e.getStackTrace().length;
                if (length == 0 && f) {
                    f = false;
                    System.err.println("c===" + c);
                }
                System.out.printf("报错异常：：%s, 堆栈长度：：%s%n", e, length);
            }
        }
    }

}

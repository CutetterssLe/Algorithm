package com.xing.singleton;

/**
 * @author Mystery
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.xing.singleton.SingletonObj");
        Object o = clazz.newInstance();
        System.out.println(o);
    }

}

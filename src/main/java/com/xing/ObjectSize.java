package com.xing;

/**
 * @author Mystery
 */
public class ObjectSize<E, T> {
    static int i = 100;
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (i < 0) {
                        return;
                    } else {
                        i--;
                    }
                    System.out.println("i1==" + i);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (i < 0) {
                        return;
                    } else {
                        i--;
                    }
                    System.out.println("i2==" + i);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (i < 0) {
                        return;
                    } else {
                        i--;
                    }
                    System.out.println("i3==" + i);
                }
            }).start();
        }
    }
}

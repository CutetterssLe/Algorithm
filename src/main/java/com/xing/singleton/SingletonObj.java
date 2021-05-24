package com.xing.singleton;

/**
 * @author Mystery
 */
public class SingletonObj {

    private SingletonObj() {

    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObj instance;

        Singleton() {
            instance = new SingletonObj();
        }

        private SingletonObj getInstance() {
            return instance;
        }
    }

    public static SingletonObj getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}

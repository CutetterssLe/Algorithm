package com.xing.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Mystery
 */
public class Mutex {

    private static final AtomicBoolean LOCKED = new AtomicBoolean(false);

    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);
        while (waiters.peek() != current ||
                !LOCKED.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }
        waiters.remove();
        if (wasInterrupted) {
            current.interrupt();
        }
    }

    public void unlock() {
        LOCKED.set(false);
        LockSupport.unpark(waiters.peek());
    }

    public static void main(String[] args) {
        Queue<String> waiters = new ConcurrentLinkedQueue<>();
        waiters.add("!");
        waiters.add("2");
        waiters.add("3");
        System.out.println(waiters.peek());
        waiters.remove();
        System.out.println(waiters.peek());
        waiters.remove();
        System.out.println(waiters.peek());
        waiters.remove();
        System.out.println(waiters.peek());
    }
}

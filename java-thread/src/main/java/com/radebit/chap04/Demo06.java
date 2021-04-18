package com.radebit.chap04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Rade
 * @Date 2021/4/18 18:00:00
 * @Description 公平锁与非公平锁
 * Lock分为公平锁与非公平锁两种。公平锁表示线程获取锁的顺序是按照 加锁的顺序来分配的，也就是先来先得。
 * 而非公平锁就是一种获取锁的抢占机制 ，是随机获得锁，与公平锁不一样的是先来的不一定先得到锁，
 * 这种方式可能会造成某些线程一直都拿不到锁，结果也就是不公平的。
 */
public class Demo06 {
    public static void main(String[] args) {
//        Demo06Service demo06Service = new Demo06Service(true);  // 公平锁
        Demo06Service demo06Service = new Demo06Service(false);  // 非公平锁
        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Demo06Thread(demo06Service);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}

class Demo06Service {
    private Lock lock;

    public Demo06Service(boolean isFair) {
        // 无参的ReentrantLock是非公平锁，通过boolean参数控制锁的类型，true-公平锁，否则就是非公平锁
        lock = new ReentrantLock(isFair);
    }

    public void foo() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁定");
        } finally {
            lock.unlock();
        }
    }
}

class Demo06Thread extends Thread {
    private Demo06Service demo06Service;

    public Demo06Thread(Demo06Service demo06Service) {
        this.demo06Service = demo06Service;
    }

    @Override
    public void run() {
        demo06Service.foo();
    }
}
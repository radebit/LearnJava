package com.radebit.chap04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Rade
 * @Date 2021/4/18 11:48:48
 * @Description ReentrantLock
 */
public class Demo01 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Demo01Thread(lock);
        t1.start();
        Thread t2 = new Demo01Thread(lock);
        t2.start();
        Thread t3 = new Demo01Thread(lock);
        t3.start();

    }
}

class Demo01Thread extends Thread {
    private Lock lock;

    public Demo01Thread(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        // 加上同步锁
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
        }
        // 解开同步锁
        lock.unlock();
    }
}

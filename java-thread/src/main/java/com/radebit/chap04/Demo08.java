package com.radebit.chap04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Rade
 * @Date 2021/4/18 21:47:47
 * @Description ReentrantReadWriteLock
 */
public class Demo08 {
    public static void main(String[] args) {
        Demo08Service demo08Service = new Demo08Service();
        Thread t1 = new Demo08ThreadA(demo08Service);
        t1.setName("读锁A");
        t1.start();

//        Thread t2 = new Demo08ThreadB(demo08Service);
//        t2.setName("写锁B");
//        t2.start();

        Thread t3 = new Demo08ThreadA(demo08Service);
        t3.setName("读锁C");
        t3.start();
    }
}

class Demo08Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得读锁" + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁" + System.currentTimeMillis());
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得写锁" + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁" + System.currentTimeMillis());
            lock.writeLock().unlock();
        }
    }
}

class Demo08ThreadA extends Thread {
    private Demo08Service demo08Service;

    public Demo08ThreadA(Demo08Service demo08Service) {
        this.demo08Service = demo08Service;
    }

    @Override
    public void run() {
        demo08Service.read();
    }
}

class Demo08ThreadB extends Thread {
    private Demo08Service demo08Service;

    public Demo08ThreadB(Demo08Service demo08Service) {
        this.demo08Service = demo08Service;
    }

    @Override
    public void run() {
        demo08Service.write();
    }
}
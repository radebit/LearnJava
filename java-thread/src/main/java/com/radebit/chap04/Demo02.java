package com.radebit.chap04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Rade
 * @Date 2021/4/18 13:50:50
 * @Description synchronized和Lock
 */
public class Demo02 {
    public static void main(String[] args) {
        Demo02Service demo02Service = new Demo02Service();
        Thread t1 = new Demo02ThreadA(demo02Service);
        t1.setName("A");
        t1.start();

        Thread t2 = new Demo02ThreadB(demo02Service);
        t2.setName("B");
        t2.start();
    }
}

class Demo02Service {
    private Lock lock = new ReentrantLock();

    /*synchronized*/
    public void foo1() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始执行foo1方法" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "结束执行foo1方法" + System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*synchronized*/
    public void foo2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始执行foo2方法" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "结束执行foo2方法" + System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo02ThreadA extends Thread {
    private Demo02Service demo02Service;

    public Demo02ThreadA(Demo02Service demo02Service) {
        this.demo02Service = demo02Service;
    }

    @Override
    public void run() {
        demo02Service.foo1();
    }
}

class Demo02ThreadB extends Thread {
    private Demo02Service demo02Service;

    public Demo02ThreadB(Demo02Service demo02Service) {
        this.demo02Service = demo02Service;
    }

    @Override
    public void run() {
        demo02Service.foo2();
    }
}
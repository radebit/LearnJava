package com.radebit.chap03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/4/17 22:36:36
 * @Description wait条件发生变化
 * 在使用wait/notify模式时，需要注意另外一种情况，就是wait等待的条件发生了变化，很容易会造成程序逻辑的混乱。
 */
public class Demo08 {
    public static void main(String[] args) throws InterruptedException {
        Demo08Service demo08Service = new Demo08Service();
        Thread t1 = new Demo08ThreadB(demo08Service);
        t1.start();
        Thread t2 = new Demo08ThreadB(demo08Service);
        t2.start();
        Thread.sleep(1000);
        Thread t3 = new Demo08ThreadA(demo08Service);
        t3.start();
    }
}

class Demo08Service {
    private List list = new ArrayList();

    private Object lock = new Object();

    public void add() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "开始添加元素");
            list.add("a");
            System.out.println(Thread.currentThread().getName() + "结束添加元素");
            lock.notifyAll();
        }
    }

    public void subtrac() {
        try {
            synchronized (lock) {
                if (list.size() <= 0) {
                    System.out.println(Thread.currentThread().getName() + "开始等待数据");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "结束等待数据");
                }
                if (list.size() > 0) {
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "移除了一个元素，list.size = " + list.size());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo08ThreadA extends Thread {
    private Demo08Service service;

    public Demo08ThreadA(Demo08Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.add();
    }
}

class Demo08ThreadB extends Thread {
    private Demo08Service service;

    public Demo08ThreadB(Demo08Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.subtrac();
    }
}
package com.radebit.chap04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Rade
 * @Date 2021/4/18 16:45:45
 * @Description 使用Condition唤醒不同的线程
 * 分别唤醒不同的线程，就需要使用多个Condition对象，也就是Condition对象可以唤醒部分指定的线程，有助于提升程序的运行效率。
 */
public class Demo04 {
    public static void main(String[] args) throws InterruptedException {
        Demo04Service demo04Service = new Demo04Service();
        Thread t1 = new Demo04ThreadA(demo04Service);
        t1.setName("A");
        t1.start();
        Thread t2 = new Demo04ThreadB(demo04Service);
        t2.setName("B");
        t2.start();

        Thread.sleep(2000);
        demo04Service.signal();
    }
}

class Demo04Service {
    private Lock lock = new ReentrantLock();
    //    private Condition condition = lock.newCondition();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();


    public void awaitA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始执行awaitA方法" + System.currentTimeMillis());
            conditionA.await();
            System.out.println(Thread.currentThread().getName() + "结束执行awaitA方法" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始执行awaitB方法" + System.currentTimeMillis());
            conditionB.await();
            System.out.println(Thread.currentThread().getName() + "结束执行awaitB方法" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
//            System.out.println("唤醒所有线程");
//            condition.signalAll();
            System.out.println("唤醒ConditionA里的全部线程");
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Demo04ThreadA extends Thread {
    private Demo04Service demo04Service;

    public Demo04ThreadA(Demo04Service demo04Service) {
        this.demo04Service = demo04Service;
    }

    @Override
    public void run() {
        demo04Service.awaitA();
    }
}

class Demo04ThreadB extends Thread {
    private Demo04Service demo04Service;

    public Demo04ThreadB(Demo04Service demo04Service) {
        this.demo04Service = demo04Service;
    }

    @Override
    public void run() {
        demo04Service.awaitB();
    }
}
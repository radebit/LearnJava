package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/17 22:16:16
 * @Description wait(long)的使用
 * 带一个long参数的方法的作用：等待某一时间内是否有线程对象锁进行唤醒，如果超过这个等待时间线程会自动唤醒。
 * sleep(long)与wait(long)非常相像，都是在指定的时间后线程会自动唤醒，区别在于sleep是不会释放对象锁，而wait方法可以释放对象锁。
 */
public class Demo06 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo06ThreadA(lock);
        t1.setName("A");
        t1.start();

        Thread t3 = new Demo06ThreadA(lock);
        t3.setName("C");
        t3.start();

        Thread.sleep(5000);

        Thread t2 = new Demo06ThreadB(lock);
        t2.setName("B");
        t2.start();
    }
}

class Demo06ThreadA extends Thread {
    private Object lock;

    public Demo06ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "进入同步代码块，准备执行wait方法：" + System.currentTimeMillis());
//                lock.wait();
                lock.wait(2000);
                System.out.println(Thread.currentThread().getName() + "结束同步代码块：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo06ThreadB extends Thread {
    private Object lock;

    public Demo06ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "开始唤醒：" + System.currentTimeMillis());
            lock.notify();
            System.out.println(Thread.currentThread().getName() + "结束唤醒：" + System.currentTimeMillis());
        }
    }
}
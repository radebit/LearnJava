package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/30 11:25:25
 * @Description synchronized 代码块间的同步性
 * 当一个线程访问Object的一个synchronized(this)同步代码块时，其他线程对这个Object的其他synchronized(this)同步的访问会被阻塞，
 * 说明synchronized使用的对象锁是同一个。
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Demo13Service demo13Service = new Demo13Service();
        Thread t1 = new Demo13ThreadA(demo13Service);
        t1.start();
        Thread.sleep(10);
        Thread t2 = new Demo13ThreadB(demo13Service);
        t2.start();
    }
}

class Demo13Service {
    public void foo1() {
        try {
            synchronized (this) {
                System.out.println("foo1开始于：" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("foo1结束于：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo2() {
        synchronized (this) {
            System.out.println("foo2开始于：" + System.currentTimeMillis());
            System.out.println("foo2结束于：" + System.currentTimeMillis());
        }
    }
}

class Demo13ThreadA extends Thread {
    private Demo13Service demo13Service;

    public Demo13ThreadA(Demo13Service demo13Service) {
        this.demo13Service = demo13Service;
    }

    @Override
    public void run() {
        demo13Service.foo1();
    }
}

class Demo13ThreadB extends Thread {
    private Demo13Service demo13Service;

    public Demo13ThreadB(Demo13Service demo13Service) {
        this.demo13Service = demo13Service;
    }

    @Override
    public void run() {
        demo13Service.foo2();
    }
}
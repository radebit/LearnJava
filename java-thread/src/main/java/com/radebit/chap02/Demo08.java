package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/29 21:46:46
 * @Description 同步不具有继承性
 */
public class Demo08 {
    public static void main(String[] args) {
        Demo08ServiceB demo08ServiceB = new Demo08ServiceB();
        Thread t1 = new Demo08Thread(demo08ServiceB);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Demo08Thread(demo08ServiceB);
        t2.setName("T2");
        t2.start();
    }
}

class Demo08ServiceA {
    synchronized public void foo() {
        try {
            System.out.println("父类：" + Thread.currentThread().getName() + "，开始于：" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("父类：" + Thread.currentThread().getName() + "，结束于：" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo08ServiceB extends Demo08ServiceA {
    //    public void foo() {
    synchronized public void foo() {
        try {
            System.out.println("子类：" + Thread.currentThread().getName() + "，开始于：" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("子类：" + Thread.currentThread().getName() + "，结束于：" + System.currentTimeMillis());
            super.foo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo08Thread extends Thread {
    private Demo08ServiceB demo08ServiceB;

    public Demo08Thread(Demo08ServiceB demo08ServiceB) {
        this.demo08ServiceB = demo08ServiceB;
    }

    @Override
    public void run() {
        demo08ServiceB.foo();
    }
}

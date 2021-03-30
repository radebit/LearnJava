package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/30 10:59:59
 * @Description 半异步半同步，不在synchronized 代码块中的就是异步执行，在synchronized 代码块中的就是同步执行
 */
public class Demo12 {
    public static void main(String[] args) {
        Demo12Service demo12Service = new Demo12Service();
        Thread t1 = new Demo12Thread(demo12Service);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Demo12Thread(demo12Service);
        t2.setName("T2");
        t2.start();
    }
}

class Demo12Service {
    public void foo() {
        for (int i = 0; i < 100; i++) {
            System.out.println("非同步线程" + Thread.currentThread().getName() + ",i=" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("同步线程" + Thread.currentThread().getName() + ",i=" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Demo12Thread extends Thread {
    private Demo12Service demo12Service;

    public Demo12Thread(Demo12Service demo12Service) {
        this.demo12Service = demo12Service;
    }

    @Override
    public void run() {
        demo12Service.foo();
    }
}
package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 19:17:17
 * @Description 当一个线程执行的代码出现了异常，其所持有的锁会自动释放。
 */
public class Demo07 {
    public static void main(String[] args) {
        Demo07Service demo07Service = new Demo07Service();
        Thread t1 = new Demo07Thread(demo07Service);
        t1.setName("A");
        t1.start();
        Thread t2 = new Demo07Thread(demo07Service);
        t2.start();
    }
}

class Demo07Service {
    synchronized public void foo() {
        if (Thread.currentThread().getName().equals("A")) {
            System.out.println("线程A开始于=" + System.currentTimeMillis());
            while (true) {
                if (("" + Math.random()).startsWith("0.123456")) {
                    System.out.println("线程A结束于=" + System.currentTimeMillis());
                    Integer.parseInt("A");  // 制造异常
                }
            }
        } else {
            System.out.println("线程B开始于=" + System.currentTimeMillis());
        }
    }
}

class Demo07Thread extends Thread {
    private Demo07Service demo07Service;

    public Demo07Thread(Demo07Service demo07Service) {
        this.demo07Service = demo07Service;
    }

    @Override
    public void run() {
        demo07Service.foo();
    }
}
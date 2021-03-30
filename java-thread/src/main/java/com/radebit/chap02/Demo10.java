package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/30 10:26:26
 * @Description 同步代码块
 */
public class Demo10 {
    public static void main(String[] args) {
        Demo10Service demo10Service = new Demo10Service();
        Thread t1 = new Demo10Thread(demo10Service);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Demo10Thread(demo10Service);
        t2.setName("T2");
        t2.start();
    }
}

class Demo10Service {
    public void foo() {
        try {
            synchronized (this) {
                // 同步代码块
                System.out.println(Thread.currentThread().getName() + "开始于：" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "结束于：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo10Thread extends Thread {
    private Demo10Service demo10Service;

    public Demo10Thread(Demo10Service demo10Service) {
        this.demo10Service = demo10Service;
    }

    @Override
    public void run() {
        demo10Service.foo();
    }
}
package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/30 10:43:43
 * @Description 同步代码块
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Demo11Service demo11Service = new Demo11Service();
        Thread t1 = new Demo11ThreadA(demo11Service);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Demo11ThreadB(demo11Service);
        t2.setName("T2");
        t2.start();
        Thread.sleep(6500);
        System.out.println("start1=" + Demo11Utils.start1 + ",end1=" + Demo11Utils.end1 + ",start2=" + Demo11Utils.start2 + ",end2=" + Demo11Utils.end2);
        long start = Math.min(Demo11Utils.start1, Demo11Utils.start2);
        long end = Math.max(Demo11Utils.end1, Demo11Utils.end2);
        System.out.println("总耗时：" + (end - start));
    }
}

class Demo11Utils {
    static long start1;
    static long start2;
    static long end1;
    static long end2;
}

class Demo11Service {
    public void foo() {
        try {
            System.out.println(Thread.currentThread().getName() + "开始任务");
            Thread.sleep(3000);
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "处理计算结果");
            }
            System.out.println(Thread.currentThread().getName() + "结束任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo11ThreadA extends Thread {
    private Demo11Service demo11Service;

    public Demo11ThreadA(Demo11Service demo11Service) {
        this.demo11Service = demo11Service;
    }

    @Override
    public void run() {
        Demo11Utils.start1 = System.currentTimeMillis();
        demo11Service.foo();
        Demo11Utils.end1 = System.currentTimeMillis();
    }
}

class Demo11ThreadB extends Thread {
    private Demo11Service demo11Service;

    public Demo11ThreadB(Demo11Service demo11Service) {
        this.demo11Service = demo11Service;
    }

    @Override
    public void run() {
        Demo11Utils.start2 = System.currentTimeMillis();
        demo11Service.foo();
        Demo11Utils.end2 = System.currentTimeMillis();
    }
}
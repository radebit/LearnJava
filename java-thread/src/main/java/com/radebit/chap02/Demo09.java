package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/29 22:01:01
 * @Description synchronized 的缺点（耗时长，需要等待）
 */
public class Demo09 {
    public static void main(String[] args) throws InterruptedException {
        Demo09Service demo09Service = new Demo09Service();
        Thread t1 = new Demo09ThreadA(demo09Service);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Demo09ThreadB(demo09Service);
        t2.setName("T2");
        t2.start();
        Thread.sleep(13000);
        System.out.println("start1=" + Demo09Utils.start1 + ",end1=" + Demo09Utils.end1 + ",start2=" + Demo09Utils.start2 + ",end2=" + Demo09Utils.end2);
        long start = Math.min(Demo09Utils.start1, Demo09Utils.start2);
        long end = Math.max(Demo09Utils.end1, Demo09Utils.end2);
        System.out.println("总耗时：" + (end - start));
    }
}

class Demo09Utils {
    static long start1;
    static long start2;
    static long end1;
    static long end2;
}

class Demo09Service {
    synchronized public void foo() {
        try {
            System.out.println("开始任务");
            Thread.sleep(5000);
            System.out.println("长时任务处理完成，线程：" + Thread.currentThread().getName());
            System.out.println("任务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo09ThreadA extends Thread {
    private Demo09Service demo09Service;

    public Demo09ThreadA(Demo09Service demo09Service) {
        this.demo09Service = demo09Service;
    }

    @Override
    public void run() {
        Demo09Utils.start1 = System.currentTimeMillis();
        demo09Service.foo();
        Demo09Utils.end1 = System.currentTimeMillis();
    }
}

class Demo09ThreadB extends Thread {
    private Demo09Service demo09Service;

    public Demo09ThreadB(Demo09Service demo09Service) {
        this.demo09Service = demo09Service;
    }

    @Override
    public void run() {
        Demo09Utils.start2 = System.currentTimeMillis();
        demo09Service.foo();
        Demo09Utils.end2 = System.currentTimeMillis();
    }
}
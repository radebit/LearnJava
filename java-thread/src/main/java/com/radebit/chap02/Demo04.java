package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 14:50:50
 * @Description A线程先持有Object对象的对象锁，B线程就不可以异步方式调用Object对象使用Synchronized修饰的方法，线程B
 * 只能等待线程A的方法执行完成释放对象锁才能够执行，也就是同步执行。B线程可以以异步的方式调用Object对象Synchronized 修饰的方法。
 */
public class Demo04 {
    public static void main(String[] args) {
        Demo04Service demo04Service = new Demo04Service();
        Thread t1 = new Demo04ThreadA(demo04Service);
        Thread t2 = new Demo04ThreadB(demo04Service);
        t1.start();
        t2.start();
    }
}

class Demo04Service {
    synchronized public void foo1() {
        System.out.println("开始运行foo1方法，ThreadName=" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo1方法运行结束");
    }

    synchronized public void foo2() {
        System.out.println("开始运行foo2方法，ThreadName=" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo2方法运行结束");
    }
}

class Demo04ThreadA extends Thread {
    private Demo04Service demo04Service;

    public Demo04ThreadA(Demo04Service demo04Service) {
        this.demo04Service = demo04Service;
    }

    @Override
    public void run() {
        demo04Service.foo1();
    }
}

class Demo04ThreadB extends Thread {
    private Demo04Service demo04Service;

    public Demo04ThreadB(Demo04Service demo04Service) {
        this.demo04Service = demo04Service;
    }

    @Override
    public void run() {
        demo04Service.foo2();
    }
}
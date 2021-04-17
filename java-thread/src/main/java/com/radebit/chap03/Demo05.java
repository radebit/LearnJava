package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/17 21:56:56
 * @Description notify和notifyAll
 */
public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo05ThreadA(lock);
        t1.setName("A");
        t1.start();

        Thread t3 = new Demo05ThreadA(lock);
        t3.setName("C");
        t3.start();

        Thread.sleep(2000);

        Thread t2 = new Demo05ThreadB(lock);
        t2.setName("B");
        t2.start();

    }
}

class Demo05Service {
    public void foo(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "进入了foo方法，准备执行wait方法");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + "结束了foo方法");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo05ThreadA extends Thread {
    private Object lock;

    public Demo05ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Demo05Service demo05Service = new Demo05Service();
        demo05Service.foo(lock);
    }
}

class Demo05ThreadB extends Thread {
    private Object lock;

    public Demo05ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            // notify仅随机唤醒一个线程
//            lock.notify();
            // notifyAll唤醒全部线程
            lock.notifyAll();
        }
    }
}

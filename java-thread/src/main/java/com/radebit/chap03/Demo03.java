package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/15 15:23:23
 * @Description notify方法也要在同步方法或同步代码块中使用，在调用前线程必须获得该对象的对象锁，如果没有获取适当的锁也会抛出IllegalMonitorStateException。
 * 这个方法是用来通知那些可能等待锁对象的其它线程，如果有多个线程等待，由线程调试器随机挑选一个在wait状态的线程，向其发出通知，并使等待获取该对象的对象锁。
 * <p>
 * 在执行notify方法后，当前线程不会马上释放该对象锁，wait状态的线程也不能马上获取取该对象锁，
 * 要等到执行notify方法的线程将任务执行完成后，也就是退出synchronize代码块后，当前线程才会释放锁，wait状态线程才可以获取到锁。
 * <p>
 * 当第一个获得该对象锁的wait线程运行完成后，它会释放掉该对象锁，如果 该对象没有再次使用notify语句，则对象处理空闲状态，
 * 其它wait状态的线程由于没有得到通知，还会继续处理阻塞的wait状态，直到这个对象发现次发出通知。
 */
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Demo03ThreadA(obj);
        t1.start();
        Thread.sleep(2000);
        Thread t2 = new Demo03ThreadB(obj);
        t2.start();
    }
}

class Demo03ThreadA extends Thread {
    private Object lock;

    public Demo03ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("线程A开始等待：" + System.currentTimeMillis());
                lock.wait();
                System.out.println("线程A结束等待：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo03ThreadB extends Thread {
    private Object lock;

    public Demo03ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("线程B准备发出通知：" + System.currentTimeMillis());
                lock.notify();
                System.out.println("线程B结束发出通知：" + System.currentTimeMillis());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
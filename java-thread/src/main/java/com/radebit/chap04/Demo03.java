package com.radebit.chap04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Rade
 * @Date 2021/4/18 14:30:30
 * @Description ReentrantLock实现wait和notify（Condition）
 * 关键字synchronized与wait/notify或notifyAll方法想结合可以实现等待/通知模式，ReentrantLock也可以实现同样的功能，但需要借助Condition对象。
 * Condition类是在JDK5中出现的技术，使用它有更好的灵活性，比如可以实现多路通知功能，也就是在一个Lock对象里面可以创建多个Condition实例，
 * 线程对象可以注册在指定的Condition中，从而可以有选择性地进行线程通知，在调度线程上更加灵活。
 * <p>
 * 在使用notify/notifyAll方法进行通知时，被通知线程是由JVM随机选择的，但使用ReentrantLock结合Condition类可以实现选择性通知，
 * 这个功能是非常重要的，而且在Condition在中是默认提供的。
 * <p>
 * 而synchronized就相当于整个Lock对象中只有一个单一Condition对象，所有的线程都是注册在它一个对象的身上。
 * 当线程开始notifyAll时需要通知所有正在等待的线程，没有选择权，会出现相当大效率问题。
 */
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Demo03Service demo03Service = new Demo03Service();
        Thread t1 = new Demo03Thread(demo03Service);
        t1.start();
        Thread.sleep(2000);
        demo03Service.signal();
    }
}

class Demo03Service {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await方法开始于：" + System.currentTimeMillis());
            condition.await();  // 需要在同步代码中调用，否则会抛出IllegalMonitorStateException
            System.out.println("await方法结束于：" + System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void signal() {
        lock.lock();
        System.out.println("signal方法开始于：" + System.currentTimeMillis());
        condition.signal();
        System.out.println("signal方法结束于：" + System.currentTimeMillis());
        lock.unlock();
    }
}

class Demo03Thread extends Thread {
    private Demo03Service demo03Service;

    public Demo03Thread(Demo03Service demo03Service) {
        this.demo03Service = demo03Service;
    }

    @Override
    public void run() {
        demo03Service.await();
    }
}
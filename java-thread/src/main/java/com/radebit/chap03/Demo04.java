package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/15 16:08:08
 * @Description wait方法遇到intterrup方法
 * 当线程呈wait状态时，调用线程对象的interrupt方法会产生InterruptedException异常。
 * 总结：
 * 1) 执行完同步代码块就会释放对象锁；
 * 2) 在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放；
 * 3) 在执行同步代码块的过程中，执行了锁所属对象的wait 方法，这个线程会释放对象锁，而此线程对象会进行线程等待池中等待被唤醒。
 */
public class Demo04 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo04Thread(lock);
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}

class Demo04Service {
    public void foo(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始等待：" + System.currentTimeMillis());
                lock.wait();
                System.out.println("线程" + Thread.currentThread().getName() + "结束等待：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            System.out.println("出现异常，因为wait状态的线程被interrupt了");
            e.printStackTrace();
        }
    }
}

class Demo04Thread extends Thread {
    private Object lock;

    public Demo04Thread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Demo04Service demo04Service = new Demo04Service();
        demo04Service.foo(lock);
    }
}
package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/18 00:43:43
 * @Description ThreadLocal类具有隔离性
 */
public class Demo20 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread t1 = new Demo20Thread(threadLocal);
        t1.start();
        Thread t2 = new Demo20Thread(threadLocal);
        t2.start();
    }
}

class Demo20Thread extends Thread {
    private ThreadLocal threadLocal;

    public Demo20Thread(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                threadLocal.set(Thread.currentThread().getName() + "_" + i);
                System.out.println(Thread.currentThread().getName() + " get value = " + threadLocal.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

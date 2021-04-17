package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/17 22:47:47
 * @Description 一个生产者与一个消费者
 * 如果在这个代码的基础上，设计出多生产者与多消费者，在运行过程很有可能会出现『假死』的情况，也就是所有的线程都是wait状态。
 */
public class Demo09 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Demo09Producer(lock);
        t1.start();

        Thread t2 = new Demo09Consumer(lock);
        t2.start();
    }
}

class Demo09VO {
    public static String value = "";
}


// 生产者
class Demo09Producer extends Thread {
    private Object lock;

    public Demo09Producer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    if (!Demo09VO.value.equals("")) {
                        lock.wait();
                    }
                    String value = System.currentTimeMillis() + "_" + System.nanoTime();
                    System.out.println("Set的值：" + value);
                    Demo09VO.value = value;
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 消费者
class Demo09Consumer extends Thread {
    private Object lock;

    public Demo09Consumer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    if (Demo09VO.value.equals("")) {
                        lock.wait();
                    }
                    System.out.println("Get的值：" + Demo09VO.value);
                    Demo09VO.value = "";
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
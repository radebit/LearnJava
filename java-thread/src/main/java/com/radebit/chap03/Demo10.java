package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/17 22:47:47
 * @Description 多生产与多消费者
 * 假设生产A它在生产数据，其它3个线程(生产者B、消费者A、消费者B)都是呈等待状态，当生产者A生产完成后，随机唤醒1个线程，刚好唤醒了生产B，
 * 生产者B发现ValueObject中有数据所以进行到等待状态(生产者A竞争锁，生产者B、消费者A、消费者B等待状态)，A又重新获得锁但是它发现创建出来的值没还有被消费，
 * 所以它又进入等待状态，结果就是4个线程都是在待状态。怎样样解决这个问题，使用notifyAll方法把有的线程都唤醒，保证生产出来的值一定会被消费掉。
 */
public class Demo10 {
    public static void main(String[] args) {
        Object lock = new Object();
        int size = 6;   // 线程数组
        Thread[] producers = new Thread[size];
        Thread[] consumers = new Thread[size];
        for (int i = 0; i < size; i++) {
            producers[i] = new Demo10Producer(lock);
            producers[i].setName("Producers_" + i);

            consumers[i] = new Demo10Consumer(lock);
            consumers[i].setName("Consumers_" + i);

            producers[i].start();
            consumers[i].start();
        }


    }
}

class Demo10VO {
    public static String value = "";
}


// 生产者
class Demo10Producer extends Thread {
    private Object lock;

    public Demo10Producer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    if (!Demo10VO.value.equals("")) {
                        System.out.println(Thread.currentThread().getName() + "等待中...");
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + "生产中...");
                    String value = System.currentTimeMillis() + "_" + System.nanoTime();
//                    System.out.println("Set的值：" + value);
                    Demo10VO.value = value;
//                    lock.notify();
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 消费者
class Demo10Consumer extends Thread {
    private Object lock;

    public Demo10Consumer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) {
                    if (Demo10VO.value.equals("")) {
                        System.out.println(Thread.currentThread().getName() + "等待中...");
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + "消费中...");
//                    System.out.println("Get的值：" + Demo10VO.value);
                    Demo10VO.value = "";
//                    lock.notify();
                    lock.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
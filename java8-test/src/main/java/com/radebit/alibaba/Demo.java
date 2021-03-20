package com.radebit.alibaba;

import cn.hutool.core.util.RandomUtil;

/**
 * @Author Rade
 * @Date 2021/3/18 18:55:55
 * @Description 生产者有1个，消费者有2个。生产者每隔3秒生成一个随机数；
 * 每个消费者每500毫秒读取一次当前的数值，并且打印出来。
 */
public class Demo {
    public static void main(String[] args) {
        NumData numData = new NumData();
        Thread producerThread = new Thread(new Producer(numData));
        Thread consumer01Thread = new Thread(new Consumer01(numData));
        Thread consumer02Thread = new Thread(new Consumer02(numData));
        producerThread.start();
        consumer01Thread.start();
        consumer02Thread.start();
    }
}

class Producer implements Runnable {
    NumData numData;

    public Producer(NumData numData) {
        this.numData = numData;
    }

    @Override
    public void run() {
        while (true) {
            numData.setNum(RandomUtil.randomInt(1000, 9999));
            System.out.println("生产者生产了：" + numData.getNum());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer01 implements Runnable {
    NumData numData;

    public Consumer01(NumData numData) {
        this.numData = numData;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("消费者01拿到了：" + this.numData.getNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer02 implements Runnable {
    NumData numData;

    public Consumer02(NumData numData) {
        this.numData = numData;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("消费者02拿到了：" + this.numData.getNum());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NumData {
    private int num = 0;

    synchronized public void setNum(int num) {
        this.num = num;
    }

    synchronized public int getNum() {
        return num;
    }
}
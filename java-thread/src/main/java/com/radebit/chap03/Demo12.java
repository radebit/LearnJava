package com.radebit.chap03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/4/17 23:40:40
 * @Description 一生产者多消费者
 * 注意：
 * 1. 消费者在判断集合是否有数据时不能使用if，有可能重复唤醒的还是消费，需要使用while语句判断，保证集合中一定是有数据的。
 * 2. 消费者唤醒线程不使用notify，notify是随机唤醒一个线程，万一重复唤醒消费者就没有办法重新生产新的数据。需要使用notifyAll方法。
 */
public class Demo12 {
    public static void main(String[] args) {
        Demo12VO vo = new Demo12VO();
        Thread producer = new Demo12Producer(vo);
        producer.setName("生产者");
        producer.start();

        Thread[] consumers = new Thread[5];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Demo12Consumer(vo);
            consumers[i].setName("消费者" + (char) ('A' + i));
            consumers[i].start();
        }
    }
}

class Demo12VO {
    private List<String> list = new ArrayList<>();

    synchronized public void push(String val) {
        try {
            if (list.size() == 1) {
                System.out.println(Thread.currentThread().getName() + "等待中");
                this.wait();
            }
            list.add(val);
            System.out.println(Thread.currentThread().getName() + "：添加数据" + val);
            System.out.println(Thread.currentThread().getName() + "：还有" + list.size() + "个数据");
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = null;
        try {
            while (list.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "等待中");
                this.wait();
            }
            returnValue = list.get(0);
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + "：消费数据" + returnValue);
            System.out.println(Thread.currentThread().getName() + "：还有" + list.size() + "个数据");
//            this.notify();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}

class Demo12Producer extends Thread {
    private Demo12VO vo;

    public Demo12Producer(Demo12VO vo) {
        this.vo = vo;
    }

    @Override
    public void run() {
        while (true) {
            vo.push(Math.random() + "");
        }
    }
}

class Demo12Consumer extends Thread {
    private Demo12VO vo;

    public Demo12Consumer(Demo12VO vo) {
        this.vo = vo;
    }

    @Override
    public void run() {
        while (true) {
            vo.pop();
        }
    }
}
package com.radebit.chap3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/4/13 21:07:07
 * @Description 实现简单的线程间通信，但是有个弊端，线程B需要不停的轮询检测一个条件，这样做会浪费CPU资源。
 * 如果轮询的时间很小，更浪费CPU资源，如果轮询时间间隔很大，有可能会取不到我们想要的数据。
 */
public class Demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread t1 = new Demo01ThreadA(list);
        t1.start();

        Thread t2 = new Demo01ThreadB(list);
        t2.start();
    }
}

class Demo01ThreadA extends Thread {
    private List list;

    public Demo01ThreadA(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo01ThreadB extends Thread {
    // 强制线程从公共堆栈中获取数据
    volatile private List list;

    public Demo01ThreadB(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("List已经有5个数据了，线程B退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
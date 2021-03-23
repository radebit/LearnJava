package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 11:56:56
 * @Description 成员变量不是线程安全的，synchronized 保证线程安全
 * 如果有两个线程同时操作业务对象中的成员变量，可能会产生“非线程安全”的问题，需要在方法前使用关键字synchronized进行修饰
 */
public class Demo02 {
    public static void main(String[] args) {
        Demo02Service demo02Service = new Demo02Service();
        Thread t1 = new Demo02ThreadA(demo02Service);
        t1.start();
        Thread t2 = new Demo02ThreadB(demo02Service);
        t2.start();
    }
}

class Demo02Service {
    private int num;

    synchronized public void add(String username) {
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            num = 200;
            System.out.println("b set over");
        }
        System.out.println("username=" + username + ";num=" + num);
    }
}

class Demo02ThreadA extends Thread {
    private Demo02Service demo02Service;

    public Demo02ThreadA(Demo02Service demo02Service) {
        this.demo02Service = demo02Service;
    }

    @Override
    public void run() {
        demo02Service.add("a");
    }
}

class Demo02ThreadB extends Thread {
    private Demo02Service demo02Service;

    public Demo02ThreadB(Demo02Service demo02Service) {
        this.demo02Service = demo02Service;
    }

    @Override
    public void run() {
        demo02Service.add("b");
    }
}
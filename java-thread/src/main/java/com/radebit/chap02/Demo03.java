package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 11:56:56
 * @Description synchronized 取到的锁都是对象锁，而不是把一段代码或方法作为锁，所以哪个线程先执行带synchronized 关键字修饰的方法，
 * 哪个方法就持有该方法所属对象的锁，其他线程只能呈等待状态，前提是多个线程访问的是同一个对象。如果多个线程访问的是不同的对象，JVM会创建
 * 出多个对象锁。
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo03Service demo03Service1 = new Demo03Service();
        Demo03Service demo03Service2 = new Demo03Service();
        Thread t1 = new Demo03ThreadA(demo03Service1);
        t1.start();
        Thread t2 = new Demo03ThreadB(demo03Service2);
        t2.start();
    }
}

class Demo03Service {
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

class Demo03ThreadA extends Thread {
    private Demo03Service demo03Service;

    public Demo03ThreadA(Demo03Service demo03Service) {
        this.demo03Service = demo03Service;
    }

    @Override
    public void run() {
        demo03Service.add("a");
    }
}

class Demo03ThreadB extends Thread {
    private Demo03Service demo03Service;

    public Demo03ThreadB(Demo03Service demo03Service) {
        this.demo03Service = demo03Service;
    }

    @Override
    public void run() {
        demo03Service.add("b");
    }
}
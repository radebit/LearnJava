package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 11:45:45
 * @Description 局部变量不存在线程安全问题，永远都是线程安全的，这是由局部变量是私有的特征造成的。
 */
public class Demo01 {
    public static void main(String[] args) {
        Demo01Service demo01Service = new Demo01Service();
        Thread t1 = new Demo01ThreadA(demo01Service);
        t1.start();
        Thread t2 = new Demo01ThreadB(demo01Service);
        t2.start();
    }
}

class Demo01Service {
    public void add(String username) {
        int num = 0;
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

class Demo01ThreadA extends Thread {
    private Demo01Service demo01Service;

    public Demo01ThreadA(Demo01Service demo01Service) {
        this.demo01Service = demo01Service;
    }

    @Override
    public void run() {
        demo01Service.add("a");
    }
}

class Demo01ThreadB extends Thread {
    private Demo01Service demo01Service;

    public Demo01ThreadB(Demo01Service demo01Service) {
        this.demo01Service = demo01Service;
    }

    @Override
    public void run() {
        demo01Service.add("b");
    }
}
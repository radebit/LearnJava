package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/19 20:18:18
 * @Description
 */
public class Demo09 {
    public static void main(String[] args) {
        Thread t = new Demo09Thread();
        System.out.println("准备开始：" + t.isAlive());
        t.start();
        System.out.println("已经开始：" + t.isAlive());
    }
}

class Demo09Thread extends Thread {
    @Override
    public void run() {
        System.out.println("run_isAlive:" + this.isAlive());
    }
}

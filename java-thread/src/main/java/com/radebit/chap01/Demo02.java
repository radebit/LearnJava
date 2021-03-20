package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/17 14:03:03
 * @Description
 */
public class Demo02 {
    public static void main(String[] args) {
        Demo02Thread demo02Thread = new Demo02Thread();
        demo02Thread.start();
        System.out.println("运行了Main方法！");
    }
}

class Demo02Thread extends Thread {
    @Override
    public void run() {
        System.out.println("运行了Run方法！");
    }
}
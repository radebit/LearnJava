package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/17 17:49:49
 * @Description
 */
public class Demo05 {
    public static void main(String[] args) {
        Runnable r = new Demo05Thread();
        Thread t = new Thread(r);
        t.start();
        System.out.println("运行了main方法");
    }
}

class Demo05Thread implements Runnable {
    @Override
    public void run() {
        System.out.println("执行了run方法");
    }
}

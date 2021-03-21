package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/21 22:29:29
 * @Description
 */
public class Demo12 {
    public static void main(String[] args) {
        Thread t = new Demo12Thread();
        t.start();
    }
}

class Demo12Thread extends Thread {
    int count = 0;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Thread.yield();     // 放弃当前CPU资源，但是放弃时间不确定，有可能放弃后马上就获得CPU时间片
            count += i + 1;
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) + "毫秒");
    }
}

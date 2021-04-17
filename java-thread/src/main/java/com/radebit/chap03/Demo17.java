package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/18 00:21:21
 * @Description join(long)方法使用
 * 方法join(long)中的参数是设定等待的时间
 * 如果：代码改成使用sleep(2000)，运行的效果还是等待2000毫秒，那使用join(2000)与sleep(2000)有什么区别？
 * 运行效果没有任何区别，但是同步的处理上不一样，sleep不释放锁，而join底层是使用wait来实现所以会释放锁。
 */
public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo17Thread();
        t.start();
        t.join(2000);
        System.out.println("主线程结束于" + System.currentTimeMillis());
    }
}

class Demo17Thread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("子线程开始于" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("子线程结束于" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
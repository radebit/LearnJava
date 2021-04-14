package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/14 17:08:08
 * @Description wait方法的作用是使得当前正在执行的线程进入等待状态，wait方法是Object类的方法，改方法用来将当前线程放入到【预执行队列】中，
 * 并且在wait所在的代码进行停止执行，直到接到通知或被中断为止。在调用wait方法之前，线程必须获得该对象的对象锁，也就是说只能在同步方法或者
 * 同步代码块中调用wait方法。如果在执行wait方法之后，当前线程锁会自动释放。当wait方法返回线程与其他线程重新竞争获得锁。
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            /**
             String str = new String();
             // Exception in thread "main" java.lang.IllegalMonitorStateException
             str.wait();
             **/
            String str = new String();
            System.out.println("同步代码块之前");
            synchronized (str) {
                System.out.println("同步代码块begin");
                str.wait();
                System.out.println("wait之后");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

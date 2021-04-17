package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/18 00:39:39
 * @Description ThreadLocal类的基本用法
 */
public class Demo19 {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        if (threadLocal.get() == null) {    // 获取当前线程存储的数据
            System.out.println("从未放置过值");
            threadLocal.set("a");   // 保存当前线程的数据
        }
        System.out.println(threadLocal.get());
    }
}

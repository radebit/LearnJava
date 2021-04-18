package com.radebit.chap05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Rade
 * @Date 2021/4/18 23:03:03
 * @Description Callable接口
 * Runnable是执行工作的独立任务，但是它不返回任何值。如果希望任务在完成的同时能够返回一个值，可以通过实现Callable接口。
 * 在JDK5.0中引入的Callable接口是一种具有类型参数的泛型，它的类型参数表示从方法call中返回的值的类型。
 */
public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Demo03Callable();
        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("返回的值：" + task.get());
    }
}

class Demo03Callable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "调用了Callable接口的实现类");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (int) (Math.random() * 10);
    }
}
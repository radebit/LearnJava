package com.radebit.chap01;

import org.junit.Test;

/**
 * @Author Rade
 * @Date 2021/3/17 13:33:33
 * @Description
 */
public class TestDemo {
    @Test
    public void test01() {
        System.out.println("success");
    }

    @Test
    public void test02() throws InterruptedException {
        while (true) {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }
}

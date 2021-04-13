package com.radebit.newcoder;

import org.junit.Test;

/**
 * @Author Rade
 * @Date 2021/4/9 15:45:45
 * @Description 剑指offer
 */
public class OfferTest {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n≤39
     */
    @Test
    public void fibonacci() {
        int n = 4;
        double res = (1 / Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n));
        System.out.println((int)res);
    }
}

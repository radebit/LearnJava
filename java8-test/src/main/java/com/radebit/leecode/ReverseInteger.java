package com.radebit.leecode;

import java.util.Arrays;

/**
 * @Author Rade
 * @Date 2021/3/6 15:09:09
 * @Description https://leetcode-cn.com/problems/reverse-integer/
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,31)-1);
        System.out.println(reverse(12312321));
    }

    public static int reverse(int x) {
        boolean f = false;
        if (x <= 0) {
            long xl = (long) x * -1;
            if (xl != -x) {
                return 0;
            }
            x = -x;
            f = true;
        }
        int xLen = String.valueOf(x).length();
        int[] result = new int[xLen];
        for (int i = 0; i < xLen; i++) {
            result[i] = (x / (int) (Math.pow(10, i))) % 10;
//            System.out.println("result[i]:" + result[i]);
        }
        int resNum = 0;
//        System.out.println(Arrays.toString(result));
        if (xLen >= 10 && result[0] >= 6) {
            return 0;
        }
        for (int j = result.length - 1; j >= 0; j--) {
            resNum = resNum + result[j] * (int) (Math.pow(10, result.length - j - 1));
//            System.out.println("res:" + resNum);
            if (resNum<0){
                return 0;
            }
        }
        if (f) {
            // 负数
            resNum = resNum * -1;
        }
        return resNum;
    }
}

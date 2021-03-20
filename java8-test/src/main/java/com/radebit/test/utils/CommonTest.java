package com.radebit.test.utils;

import java.util.Scanner;

/**
 * @Author Rade
 * @Date 2021/3/5 22:21:21
 * @Description
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 */
public class CommonTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int L = scanner.nextInt();
            int[] result = new int[100];
            boolean resultFlag = false;
            for (int i = L; i < 100; i++) {
                // i是连续数字个数
                int baseNum = 0;
                int countNum = 0;
                while (true) {
                    int count = 0;
                    for (int j = 0; j < i; j++) {
                        if (j == 0) {
                            countNum = baseNum;
                        } else {
                            countNum++;
                        }
                        result[j] = countNum;
                        count += countNum;
                    }
                    if (count == N) {
                        resultFlag = true;
                        break;
                    } else {
                        countNum = 0;
                    }
                    baseNum++;
                    if (baseNum > N / 2) {
                        break;
                    }
                }
                // 判断是否有结果
                if (resultFlag) {
                    break;
                }
            }
            // 判断是否有结果
            if (resultFlag) {
                for (int i = 0; i < result.length; i++) {
                    if (result[i] == 0 && i > 0) {
                        System.out.println();
                        break;
                    }
                    if (i == 0) {
                        System.out.printf("%d", result[i]);
                    } else {
                        System.out.printf(" %d", result[i]);
                    }
                }
            } else {
                System.out.println("no");
            }
        }
    }
}

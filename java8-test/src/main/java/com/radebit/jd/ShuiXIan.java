package com.radebit.jd;

/**
 * @Author Rade
 * @Date 2021/4/10 17:27:27
 * @Description
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，
 * 它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。
 * <p>
 * 输出描述
 * 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，
 * 如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开; 如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行。
 * <p>
 * <p>
 * 样例输入
 * 100 120
 * 300 380
 * <p>
 * 样例输出
 * no
 * 370 371
 */
public class ShuiXIan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            if (100 <= m && m <= n && n <= 999) {
                // 合法
                for (int i = m; i <= n; i++) {
                    // 判断是否水仙花
                    int res = (int) (Math.pow(((i) % 10), 3) + Math.pow(((i / 10) % 10), 3) + Math.pow(((i / 100) % 10), 3));
                    if (res == i) {
                        list.add(res);
                    }
                }
                if (list.size() <= 0) {
                    System.out.println("no");
                } else {
                    for (int j = 0; j < list.size(); j++) {
                        if (j == 0) {
                            System.out.printf("%d", list.get(j));
                        } else {
                            System.out.printf(" %d", list.get(j));
                        }
                    }
                }
            } else {
                System.out.println("no");
            }
        }
    }
}

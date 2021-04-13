package com.radebit.jd;

import java.util.*;

/**
 * @Author Rade
 * @Date 2021/4/10 19:36:36
 * @Description 输入描述
 * 第一行一个整数n（1≤n≤104），表示一共有n条直线。
 * <p>
 * 接下来n行，每行包括两个整数ki（0≤ki≤102）和bi（0≤bi≤102）表示直线的斜率和截距。
 * <p>
 * 输出描述
 * 一行输出n-1个数，第一个数表示平面上两直线交点的数量，第二个数表示三直线交点的数量，以此类推。
 * <p>
 * <p>
 * 样例输入
 * 3
 * 2 2
 * 3 0
 * 0 3
 * 样例输出
 * 2 0
 */
public class ZhiXian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<Integer[]> list = new ArrayList<>();
            List<Integer> kList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt();  // 斜率
                int b = scanner.nextInt();  // 截距
                list.add(new Integer[]{k, b});
                kList.add(k);
                bList.add(b);
            }
            // 先查看斜率是否一致的
            Collections.sort(kList);
            Collections.sort(bList);
            Integer lastK = kList.get(0);
            for (int i = 1; i < kList.size(); i++) {

            }

//            bList.forEach(x -> {
//                System.out.println(x + "==");
//            });

//            for (int j = 0; j < list.size(); j++) {
//                Integer[] line = list.get(j);
//            }

            // 输出
            for (int k = 2; k < n + 1; k++) {
                // k条直线相交的点数
                if (k == n) {
                    System.out.print("0" + "\n");
                } else {
                    System.out.print("0" + " ");
                }
            }
        }
    }
}

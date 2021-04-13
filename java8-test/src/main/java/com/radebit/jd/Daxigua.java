package com.radebit.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Rade
 * @Date 2021/4/10 20:18:18
 * @Description 有一串数字序列，当序列到来时，你们可以选择让数字掉落在左边或者右边。
 * 已掉落的只有左右两列。如果掉落到一列的数字和此列原有的顶部数字相同，将会合成一个原来的数字并记1分，
 * 不同的数字则会堆积（顶部数字换为新掉落的数字）并不计分。
 * 例如，左右两边的顶部元素分别是1，2，此时掉落1，如果你让它掉在左边，左边两个元素1合并，并积一分，如果你让它掉在右边，两边的顶部元素就会变成1，1，并且不计分。
 * <p>
 * 小明能提前得知数字序列，请你帮忙计算在现有规则下的最大得分。
 * <p>
 * 输入描述
 * 第一行一个正整数，n表示数字序列的数字数量。
 * <p>
 * 第二行n个正整数ai，表示第i个掉落的数字。
 * <p>
 * 1≤n≤1x105 ,1≤ai≤n
 * <p>
 * 输出描述
 * 输出一个非负整数，表示最大得分。（请在输出时加上换行符）
 * <p>
 * 样例输入
 * 6
 * 1 2 3 1 2 2
 * 样例输出
 * 2
 */
public class Daxigua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] numArr = new int[n];
            // 读入数据
            for (int i = 0; i < n; i++) {
                numArr[i] = scanner.nextInt();
            }
            int[] leftArr = new int[n];
            int[] rightArr = new int[n];
            Arrays.fill(leftArr, -1);
            Arrays.fill(rightArr, -1);
            int leftTopNum = numArr[0];
            leftArr[0] = leftTopNum;
            int leftArrIndex = 1;   // 左数组指针
            int rightArrIndex = 0;  // 右数组指针
            int rightTopNum = 0;

            for (int j = 1; j < numArr.length; j++) {
                if (numArr[j] == leftTopNum) {
                    // 元素与左顶元素相同，那么放入左数组
                    leftArr[leftArrIndex] = numArr[j];
                    leftArrIndex++;
                    leftTopNum = numArr[j];
                } else if (numArr[j] == rightTopNum) {
                    // 元素与右顶元素相同，那么放入右数组
                    rightArr[rightArrIndex] = numArr[j];
                    rightArrIndex++;
                    rightTopNum = numArr[j];
                } else {
                    // 左右元素都不相等 (待考虑)
                    rightArr[rightArrIndex] = numArr[j];
                    rightArrIndex++;
                    rightTopNum = numArr[j];
                }
            }
            // 遍历左数组求分值
            int leftGrade = 0;
            int leftLastNum = leftArr[0];
            for (int t = 1; t < leftArr.length; t++) {
                if (leftArr[t] != -1) {
                    if (leftLastNum == leftArr[t]) {
                        leftGrade++;
                    }
                    leftLastNum = leftArr[t];
                }
            }
            // 遍历右数组求分值
            int rightGrade = 0;
            int rightLastNum = rightArr[0];
            for (int t = 1; t < rightArr.length; t++) {
                if (rightArr[t] != -1) {
                    if (rightLastNum == rightArr[t]) {
                        rightGrade++;
                    }
                    rightLastNum = rightArr[t];
                }
            }

//            System.out.println("left:" + Arrays.toString(leftArr));
//            System.out.println("right:" + Arrays.toString(rightArr));
//            System.out.println("grade:" + (rightGrade + leftGrade) + "====L:" + leftGrade + "===R:" + rightGrade);
            System.out.println(rightGrade + leftGrade);
        }
    }
}

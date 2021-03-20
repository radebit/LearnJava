package com.radebit.leecode;

import java.util.Arrays;

/**
 * @Author Rade
 * @Date 2021/3/6 14:51:51
 * @Description https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TowSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int index = 0; index < nums.length; index++) {
//            System.out.println("nums_index:" + nums[index]);
            for (int j = index + 1; j < nums.length; j++) {
//                System.out.println("nums_j:" + nums[j]);
                int sum = nums[index] + nums[j];
                if (sum == target) {
                    result[0] = index;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
}

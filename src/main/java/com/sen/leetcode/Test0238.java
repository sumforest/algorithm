package com.sen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/12/5 16:26
 * @Description: 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Test0238 {

    public static void main(String[] args) {
        String str = "1234";
        String substring = str.substring(0, 3);
        productExceptSelf2(new int[]{1, 2, 3, 4});
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int k = 0; k < nums.length; k++){
                list.add(nums[k]);
            }
            list.remove(i);
            int target = 1;
            for(int j = 0; j < list.size(); j++){
                target *= list.get(j);
            }
            output[i] = target;
        }
        return output;
    }

    /**
     * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

}

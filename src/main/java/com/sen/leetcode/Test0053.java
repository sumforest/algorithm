package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/1 20:41
 * @Description: 最大子序和
 */
public class Test0053 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int count = nums[i];
            for(int j = i - 1; 0 <= j ; j--){
                count += nums[j];
                if(count > result){
                    result = count;
                }
            }
            for (int k = i + 1; k < nums.length; k++) {
                count += nums[k];
                if(count > result){
                    result = count;
                }
            }
            if (nums[i] > result) {
                result = nums[i];
            }
        }
        return result;
    }
}

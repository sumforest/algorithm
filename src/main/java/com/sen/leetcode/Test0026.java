package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/1 23:57
 * @Description: 删除数组中重复的项
 */
public class Test0026 {

    public static void main(String[] args) {
        // int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        //双指针，慢指针
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]){
                j++;
                nums[j] = nums[i + 1];
            }
        }
        return j + 1;
    }
}

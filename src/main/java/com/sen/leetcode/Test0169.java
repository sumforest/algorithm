package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/11/24 18:53
 * @Description:
 */
public class Test0169 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }
    public static int majorityElement(int[] nums) {
        int element = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > nums.length / 2){
                element = nums[i];
                break;
            }
        }
        return element;
    }
}

package com.sen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/12/4 19:37
 * @Description: 全排列（回溯法）
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Test0046 {

    public static void main(String[] args) {
        // List<Character> chars = new LinkedList<>();
        // for(int i = 0; i < 3; i++){
        //     chars.add('(');
        //     chars.add(')');
        // }
        // char[] temp = new char[chars.size()];
        // for (int i = 0; i < chars.size(); i++) {
        //     temp[i] = chars.get(i);
        // }
        // System.out.println(String.valueOf(temp));
        permute(new int[]{1, 2, 3});
    }
    public static void backtrack(int n,
                          ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}

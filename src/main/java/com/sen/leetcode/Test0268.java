package com.sen.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/11/29 18:04
 * @Description: 缺失数字
 *  给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class Test0268 {

    public static void main(String[] args) {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

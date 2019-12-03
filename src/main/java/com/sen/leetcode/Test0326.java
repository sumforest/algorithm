package com.sen.leetcode;

import java.util.*;

/**
 * @Auther: Sen
 * @Date: 2019/12/2 21:05
 * @Description: 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 */
public class Test0326 {

    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(2147483647);
        System.out.println(powerOfThree);
        Map<Character,Integer> map = new HashMap<>();
        System.out.println(map.getOrDefault('a', 0) + 1);
        map.put('a', map.get('a') + 1);
        // System.out.println(Math.max(1, 3));
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // int[] target = new int[list.size()];
        // for (int i = 0; i < target.length; i++) {
        //     target[i] = list.get(i);
        // }
    }
    private static boolean isPowerOfThree(int n) {
        long temp = 1;
        if(n == 1){
            return true;
        }
        if(n == 0){
            return false;
        }
        while(true){
            temp *= 3;
            if(n == temp){
                return true;
            }
            if(temp > n){
                return false;
            }
        }
    }
}

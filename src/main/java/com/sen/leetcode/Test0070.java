package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/2 02:09
 * @Description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class Test0070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n <= 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

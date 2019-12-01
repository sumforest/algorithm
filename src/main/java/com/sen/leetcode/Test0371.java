package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/11/29 19:57
 * @Description: 两数之和：不能使用运算符 + - 实现两数之和
 */
public class Test0371 {
    public static void main(String[] args) {
        int sum = sum(-2, 3);
        System.out.println(sum);
    }

    public static int sum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

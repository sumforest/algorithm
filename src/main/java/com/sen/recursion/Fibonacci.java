package com.sen.recursion;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 17:33
 * @Description: 递归解决斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(count(7));
    }

    //斐波那契数列
    // 1, 1, 2, 3, 5, 8, 13
    private static int count(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }else{
            return count(i - 1) + count(i - 2);
        }
    }
}

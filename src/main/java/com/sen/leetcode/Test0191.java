package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/11/24 18:11
 * @Description: 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class Test0191 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = hammingWeight(1111111101);
        System.out.println(count);
    }

    public static int hammingWeight(int n) {
        Integer integer = n;
        String ham = integer.toString();
        char[] chars = ham.toCharArray();
        int count = 0;
        for (char ch : chars) {
            if (ch == '1'){
                count++;
            }
        }
        return count;
    }
}

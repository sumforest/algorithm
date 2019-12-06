package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/11/29 23:28
 * @Description: 颠倒二级制位
 */
public class Test0190 {

    public static void main(String[] args) {
        System.out.println(reverseBits1(43261596));
        int x;
    }
    public static int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            String bit1 = Integer.toBinaryString(tmp);
            // 1.2  取有效位
            tmp = tmp & 1;
            String bit2 = Integer.toBinaryString(tmp);

            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            String bit3 = Integer.toBinaryString(tmp);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
            String bit4 = Integer.toBinaryString(result);
            System.out.println(bit4);
        }
        return result;
    }
}

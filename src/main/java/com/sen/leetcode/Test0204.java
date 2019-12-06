package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/4 16:32
 * @Description: 计算质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Test0204 {

    public static void main(String[] args) {
        countPrimesSelect(10);
    }
    public static int countPrimesSelect(int n) {
        // 1. 给0 - n之间的数加上标记
        byte[] nums = new byte[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }

        // 2. 对于非质数，进行标记清除
        for (int i = 2; i < n; i++) {
            // 如果当前数为质数
            if (nums[i] == 1) {
                // 将当前数作为基数，筛掉其倍数的数字
                for (int j = 2; i * j < n; j++) {
                    // 标记清除
                    nums[i * j] = 0;
                }
            }
        }

        //3. 遍历数组，统计质数(元素值==1)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1)
                count++;
        }
        return count;
    }

    public static int countPrimes(int n) {
        if(n == 1 || n == 0){
            return 0;
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            boolean flag = false;
            int temp = i;
            temp--;
            while(temp != 1){
                if(i % temp == 0){
                    flag = true;
                    break;
                }
                temp--;
            }
            if(!flag)
                count++;
        }
        return count;
    }
}

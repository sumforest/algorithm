package com.sen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/11/29 01:53
 * @Description: 快乐数
 */
public class Test0202 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String append = builder.append(1).append('a').toString();

        System.out.println(isHappy(7));
    }
    public static boolean isHappy(int n) {
        List<Integer> nums = new ArrayList<>();
        while(n != 1){
            int a = n % 10;
            int b = 0;
            while(n/10 != 0){
                n = n / 10;
                b += (n % 10)*(n % 10);
            }
            n = a*a + b;
            if(nums.contains(n)){
                return false;
            }else{
                nums.add(n);
            }
        }
        return true;
    }
}


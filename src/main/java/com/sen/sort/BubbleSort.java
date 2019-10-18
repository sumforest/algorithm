package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 00:18
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 34, 5, 1, 7, 8, 4, 9, 10, 3};
        System.out.println(Arrays.toString(array));
        //比较length-1轮
        for (int i = 0; i < array.length - 1; i++) {
            //每一轮的比较次数比前一次少一次
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+ 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}

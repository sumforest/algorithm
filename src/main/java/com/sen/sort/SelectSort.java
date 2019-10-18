package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 17:37
 * @Description: 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 7, 1, 5, 3, 9, 8,};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            //假定当前的i为最小值
            int minIndex = i;
            //从i的下一个元素开始遍历数组
            for (int j = i + 1; j < array.length; j++) {
                //出现比假定的最小的值更小时
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            //当i != minIndex时说明出现了更小的值，与当前的i交换位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array));

    }
}

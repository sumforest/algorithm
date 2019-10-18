package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 14:54
 * @Description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 0, 9, 3};
        // 0 1 2 4 5 8 9 3
        System.out.println(Arrays.toString(array));
        //遍历除第0个元素的所有数字
        for (int i = 1; i < array.length; i++) {
            //如果前面的数字比后面的数字大
            if (array[i - 1] > array[i]) {
                //把当前数字存起来
                int temp = array[i];
                //再遍历当前元素i前面的所有元素
                int j = 0;
                for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                    //前一个元素直接赋值给后一个元素
                    array[j + 1] = array[j];
                }
                //把temp赋值给不满足条件的后一个元素
                array[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

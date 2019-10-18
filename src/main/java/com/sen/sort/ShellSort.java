package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 16:45
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 7, 1, 0, 8, 9, 6, 3};
        System.out.println(Arrays.toString(array));
        //把数组分组，d为步长
        for (int d = array.length / 2; d > 0; d /= 2) {
            //遍历所有元素
            for (int i = d; i < array.length; i++) {
                //遍历每个组的元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果j个元素比j+d个元素大交换
                    if (array[j] > array[j + d]) {
                        int temp = array[j];
                        array[j] = array[j + d];
                        array[j + d] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

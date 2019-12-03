package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 22:09
 * @Description: 基数排序：排个最大元素的位数轮
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 115, 35, 25, 75, 886, 352, 2, 251};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] arr) {
        //找出数组中最大的元素
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //求出最大元素的位数
        int maxLength = String.valueOf(max).length();
        //定义一个二维临时数组存放数据
        int[][] temp = new int[10][arr.length];
        //用一个数组记录每个余数对应数组的元素
        int[] count = new int[10];
        //排序开始，每一轮循环取每个元素的个、十、百位
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            //遍历每个元素
            for (int j = 0; j < arr.length; j++) {
                //每个元素的每一轮余数
                int mod = arr[j] / n % 10;
                //每个元素每轮存放的位置
                temp[mod][count[mod]] = arr[j];
                count[mod]++;
            }
            //定义arr的下标
            int index = 0;
            //把每个元素按照0-9的顺序取出
            for (int k = 0; k < count.length; k++) {
                //当记录存放数据的数据部位0，遍历count[]
                if (count[k] != 0) {
                    for (int l = 0; l < count[k]; l++) {
                        arr[index] = temp[k][l];
                        index++;
                    }
                    //把录元素置0，为下轮使用
                    count[k] = 0;
                }
            }
        }
    }
}

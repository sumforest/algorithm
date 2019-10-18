package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 18:19
 * @Description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        // merge(array, 0, 2, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            //处理左边的数据
            mergeSort(arr, left, middle);
            //处理右边的数据
            mergeSort(arr, middle + 1, right);
            //归并
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        //创建一个临时数组存储数据
        int[] temp = new int[right - left+1];
        //临时数组下标
        int index = 0;
        //定义第一个数组的开始的下标
        int i = left;
        //定义第二个数组开始的下标
        int j = middle + 1;

        //循环比较每个数组
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //左边剩余的数据
        while (middle - i >= 0) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        //右边有剩余的数据
        while (right - j >= 0) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        //把临时数组替换原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + left] = temp[k];
        }
    }
}

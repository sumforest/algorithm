package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 01:34
 * @Description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 6, 7, 1, 9, 0, 2, 22,63,-1};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序方法
     * @param arr 被排序的数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            //低位
            int low = start;
            //高位
            int high = end;
            //标准元素
            int stander = arr[start];

            while (low < high) {
                //高位的元素不小于标准元素
                while (low < high && stander <= arr[high]) {
                    high--;
                }
                //当高位的元素比标准的元素小的时候高位和低位的元素交换
                arr[low] = arr[high];
                //低位元素不大于标准元素
                while (low < high && stander >= arr[low]) {
                    low++;
                }
                //当低位元素大于标准元素时低位元素和高位元素交换
                arr[high] = arr[low];
            }
            arr[low] =stander;
            //排序小的数据
            sort(arr, start, low);
            //排序大的数据
            sort(arr, low+1, end);
        }
    }
}

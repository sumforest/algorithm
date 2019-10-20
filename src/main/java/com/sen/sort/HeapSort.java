package com.sen.sort;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 17:46
 * @Description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array) {
        //开始的位置为最后一个非叶子节点的下标
        int start = (array.length - 2) / 2;
        //把数组调整为顶堆
        for (int i = start; i >= 0; i--) {
            bigHeap(array, array.length, i);
        }
        //把调整后的顶堆的根节点固定到数组最后一个元素并和最后一个叶子节点交换位置
        for (int i = array.length-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //再把交换后的数组重新调整为顶堆结构
            bigHeap(array, i, 0);
        }
    }

    /**
     * 把数组构建成大顶堆
     * @param array 数组
     * @param size 大顶堆的范围
     * @param start 开始的位置（最后一个非叶子节点）
     */
    public static void bigHeap(int[] array, int size, int start) {
        //定义左节点下标
        int leftNode = 2 * start + 1;
        //定义右节点下标
        int rightNode = 2 * start + 2;
        //假定当前的下标为最大
        int max = start;
        //如果左节点比当前非叶子节点大则交换位置
        if (leftNode < size && array[leftNode] > array[max]) {
            max = leftNode;
        }
        //如果右节点比当前非也只节点大则交换位置
        if (rightNode < size && array[rightNode] > array[max]) {
            max = rightNode;
        }
        //最后判断max是否改变，改变则非叶子节点和子节点交换位置
        if (max != start) {
            int temp = array[start];
            array[start] = array[max];
            array[max] = temp;
            //交换位置后可能破坏现有的堆结构
            bigHeap(array, size, max);
        }
    }
}

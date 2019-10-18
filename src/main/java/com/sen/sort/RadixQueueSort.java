package com.sen.sort;

import com.sen.queue.QueueDemo;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/18 22:09
 * @Description: 基数排序：排个最大元素的位数轮(基于队列实现)
 */
public class RadixQueueSort {
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
        //定义一个队列存储临时数据
        QueueDemo[] queue = new QueueDemo[10];
        //给队列的每个队列对象初始化
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new QueueDemo();
        }

        //排序开始，每一轮循环取每个元素的个、十、百位
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            //遍历每个元素
            for (int j = 0; j < arr.length; j++) {
                //每个元素的每一轮余数
                int mod = arr[j] / n % 10;
                //每个元素每轮存放的位置
                queue[mod].add(arr[j]);
            }
            //定义arr的下标
            int index = 0;
            //把每个元素按照0-9的顺序和放进去的顺序取出
            for (int k = 0; k < queue.length; k++) {
                //队列不为空则把里面的元素取出来
                    while (!queue[k].isEmpty()) {
                        arr[index] = queue[k].poll();
                        index++;
                    }
            }
        }
    }
}

package com.sen.array;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 00:51
 * @Description: 数组线性查找
 */
public class SearchArrayDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 6, 9, 7, 1, 0};
        int target = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println("index:" + index);
    }
}

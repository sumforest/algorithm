package com.sen.array;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/14 22:59
 * @Description: 删除数组元素
 */
public class DeleteArrayDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] array = new int[]{9, 8, 7, 6, 5};
        System.out.println(Arrays.toString(array));
        //要删除元素的下标
        int index = 3;
        //定义一个新数组
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }
}

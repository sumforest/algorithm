package com.sen.array;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/14 21:49
 * @Description: 添加元素
 */
public class AddArrayDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] array = new int[]{9, 8, 7};
        System.out.println(Arrays.toString(array));
        //定义一个新的数组长度+1
        int[] newArray= new int[array.length + 1];
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        //添加一个新的yuansu
        newArray[array.length] = 6;
        System.out.println(Arrays.toString(newArray));
    }
}

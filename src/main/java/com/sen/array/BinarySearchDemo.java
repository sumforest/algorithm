package com.sen.array;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 01:12
 * @Description: 二分法查找数组元素
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        //定义新数组
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //定义要查找的元素
        int target= 12;
        //定义开始位置
        int begin = 0;
        //定义结束位置
        int end = array.length - 1;
        //定义中间位置
        int mid = (begin + end) / 2;
        //定义目标元素的下标
        Integer index = null;
        while (true) {
            //如果中间元素等于目标元素
            if (array[mid] == target) {
                index = mid;
                break;
            } else {
                //中间元素小于目标元素
                if (array[mid] < target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (begin + end) / 2;
            }
            if (mid == array.length - 1) {
                break;
            }
        }
        if (index == null) {
            System.out.println("没找到目标元素");
        } else {
            System.out.println("index:" + index);
        }
    }
}

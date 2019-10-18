package com.sen.array;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 00:04
 * @Description: 面向对象的数组
 */
public class ObjectArray {

    /**
     * 定义一个对象数组
     */
    private Object[] array;

    public ObjectArray() {
        array = new Object[0];
    }

    /**
     * 获取数组的长度
     * @return 数组长度
     */
    public int Size() {
        return array.length;
    }

    /**
     * 往数组末尾添加一个元素
     * @param object 元素
     * @return 数组
     */
    public Object[] add(Object object) {
        //定义一个新数组
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = object;
        //替换原数组
        array = newArray;
        return array;
    }

    /**
     * 打印数组
     */
    public void show() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 删除指定下标的数组
     * @param index 目的数组的下标
     * @return 删除后的数组
     */
    public Object[] delete(int index) {
        //创建一个新数组
        Object[] newArray = new Object[array.length - 1];
        if (index < 0 || index > array.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
        for (int i = 0; i < newArray.length; i++) {
            //下标在删除下标的前面直接复制
            if (i < index) {
                newArray[i] = array[i];
            }
            //下标在删除下标的后面
            else {
                newArray[i] = array[i + 1];
            }
        }
        //替换原数组
        array = newArray;
        return array;
    }

    /**
     * 获取元素
     * @param index 下标
     * @return 获取的元素
     */
    public Object get(int index) {
        return array[index];
    }

    /**
     * 往指定位置插入元素
     * @param index 下标
     * @param object 元素
     * @return 新数组
     */
    public Object[] insert(int index, Object object) {
        //新建一个数组
        Object[] newArray = new Object[array.length + 1];
        if (index < 0 || index > array.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            }
            else {
                newArray[i + 1] = array[i];
            }
        }
        newArray[index] = object;
        array = newArray;
        return array;
    }

    /**
     * 替换数组的元素
     * @param index 下标
     * @param object 元素
     * @return 新数组
     */
    public Object[] set(int index, Object object) {
        array[index] = object;
        return array;
    }

    /**
     * 线性查找元素的下标
     * @param target
     * @return
     */
    public int search(Object target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 二分法查找
     * @param target 目标元素
     * @return 返回下标为-1表示没有找到
     */
    public int BinarySearch(int target) {
        //定义开始位置
        int begin = 0;
        //定义结束位置
        int end = array.length - 1;
        //定义中间位置
        int mid = (begin + end) / 2;
        //定义目标元素的下标
        int index = -1;
        while (true) {
            //如果中间元素等于目标元素
            int temp = (int) array[mid];
            if (temp == target) {
                index = mid;
                break;
            } else {
                //中间元素小于目标元素
                if (temp < target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (begin + end) / 2;
            }
            if (begin >= end) {
                break;
            }
        }
      return index;
    }
}

package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 16:35
 * @Description: 顺序存储的二叉树
 */
public class ArrayBinaryTree {

    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历顺序存储的二叉树
     * @param index 开始遍历的位置
     */
    public void preShow(int index) {
        //存入的数组为空或者长度为零直接退出
        if (this.array == null || array.length == 0) {
            return;
        }
        System.out.println(array[index]);
        //根据顺序存储的二叉树特性左节点为2*index+1
        //判断是否存在左节点
        if (2 * index + 1 <= array.length-1) {
            preShow(2 * index + 1);
        }
        //根据顺序存储的二叉树特性右节点为2*index+2
        //判断是否存在右节点
        if (2 * index + 2 <= array.length - 1) {
            preShow(2 * index + 2);
        }
    }
}

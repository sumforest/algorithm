package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 16:46
 * @Description:
 */
public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preShow(0);
    }
}

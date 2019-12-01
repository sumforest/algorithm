package com.sen.tree.avl;

import java.util.LinkedList;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 00:29
 * @Description:
 */
public class BinaryAVLTreeTest {
    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 9, 4, 6, 7};
        //创建二叉树
        BinaryAVLTree bst = new BinaryAVLTree();
        for (int i : array) {
            bst.add(new Node(i));
        }

        //双旋转
        System.out.println(bst.getRootNode().getHight());
        System.out.println(bst.getRootNode().getValue());

        LinkedList<Object> objects = new LinkedList<>();
        objects.size();

    }

}

package com.sen.tree.sort;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 00:29
 * @Description:
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 10, 12, 5, 1, 9};
        //创建二叉树
        BinarySortTree bst = new BinarySortTree();
        for (int i : array) {
            bst.add(new Node(i));
        }
        bst.middleShow();
        // System.out.println("===========search===========");
        // Node search = bst.search(12);
        // System.out.println(search.getValue());
        // Node search1 = bst.search(39);
        // System.out.println(search1);
        System.out.println("===================");

        //删除叶子节点
        // bst.delete(1);
        // bst.middleShow();
        // System.out.println("==========删除有一个节点的非叶子节点==========");
        //删除有一个节点的非叶子节点
        // bst.delete(5);
        // bst.middleShow();
        //删除有两个节点的非叶子节点
        bst.delete(10);
        bst.middleShow();
    }
}

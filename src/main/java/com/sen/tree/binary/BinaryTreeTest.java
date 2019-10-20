package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 01:04
 * @Description:
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建根节点
        TreeNode rootNode = new TreeNode(1);
        //设置根节点
        binaryTree.setRootNode(rootNode);

        //创建左节点
        TreeNode leftNode = new TreeNode(2);
        //设置左节点
        rootNode.setLeftNode(leftNode);
        //设置第三层的叶子节点
        leftNode.setLeftNode(new TreeNode(4));
        leftNode.setRightNode(new TreeNode(5));
        //创建右节点
        TreeNode rightNode = new TreeNode(3);
        //设置右节点
        rootNode.setRightNode(rightNode);
        //设置第三层的叶子节点
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));

        //前序遍历
        binaryTree.preShow();
        System.out.println();
        System.out.println("===============前序遍历============");
        //中序遍历
        binaryTree.middleShow();
        System.out.println();
        System.out.println("=============中序遍历==============");
        //后序遍历
        binaryTree.afterShow();

        //前序查找
        System.out.println();
        System.out.println("=============后续遍历==============");
        TreeNode target = binaryTree.preSearch(5);
        System.out.println(target);

        //删除节点
        System.out.println();
        System.out.println("=============删除节点==============");
        binaryTree.delete(2);
        binaryTree.preShow();
    }
}

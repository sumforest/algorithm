package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 01:04
 * @Description:
 */
public class ThreadBinaryTreeTest {
    public static void main(String[] args) {
        //创建一棵树
        ThreadBinaryTree binaryTree = new ThreadBinaryTree();
        //创建根节点
        ThreadTreeNode rootNode = new ThreadTreeNode(1);
        //设置根节点
        binaryTree.setRootNode(rootNode);

        //创建左节点
        ThreadTreeNode leftNode = new ThreadTreeNode(2);
        //设置左节点
        rootNode.setLeftNode(leftNode);
        //设置第三层的叶子节点
        leftNode.setLeftNode(new ThreadTreeNode(4));
        ThreadTreeNode fiveNode = new ThreadTreeNode(5);
        leftNode.setRightNode(fiveNode);
        //创建右节点
        ThreadTreeNode rightNode = new ThreadTreeNode(3);
        //设置右节点
        rootNode.setRightNode(rightNode);
        //设置第三层的叶子节点
        rightNode.setLeftNode(new ThreadTreeNode(6));
        rightNode.setRightNode(new ThreadTreeNode(7));

        //中序遍历
        binaryTree.middleShow();
        System.out.println();
        System.out.println("=============中序遍历==============");

        //测试线索化二叉树
        binaryTree.threadNodes();
        ThreadTreeNode fiveAfterNode = fiveNode.getRightNode();
        System.out.println(fiveAfterNode.getValue());
        System.out.println("=============测试线索化二叉树==============");

        //线索二叉树遍历
        binaryTree.threadBinaryTreeShow();
    }
}

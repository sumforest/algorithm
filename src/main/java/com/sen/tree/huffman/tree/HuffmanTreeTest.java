package com.sen.tree.huffman.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/20 00:31
 * @Description: 代码实现赫夫曼树
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 5, 14, 11, 8, 29, 23};
        Node huffmanTree = createHuffmanTree(array);
        System.out.println(huffmanTree);
    }

    /**
     * 构建赫夫曼树
     * @param array 数组
     * @return
     */
    private static Node createHuffmanTree(int[] array) {
        //创建若干个只有一个节点的二叉树集合
        List<Node> nodes = new ArrayList<>();
        for (int  value : array) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出最小的两个二叉树组成新的二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.getValue() + right.getValue());
            //把取出的两个最小的二叉树添加到新创建二叉树的子节点
            parent.setLeft(left);
            parent.setRight(right);
            //删除最小的两个二叉树
            nodes.remove(left);
            nodes.remove(right);
            //把新构建的二叉树放入二叉树集合
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

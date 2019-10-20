package com.sen.tree.huffman.code;

/**
 * @Auther: Sen
 * @Date: 2019/10/20 01:46
 * @Description: 赫夫曼编码表的节点
 */
public class Node implements Comparable<Node>{

    /**
     * 用于存储ASCII码
     */
    private Byte data;

    /**
     * 节点的权值
     */
    private int weight;

    private Node left;

    private Node right;

    public Node() {
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return o.weight-weight;
    }
}

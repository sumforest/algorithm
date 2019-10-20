package com.sen.tree.sort;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 00:28
 * @Description: 二叉排序树的节点
 */
public class Node {

    private int value;

    private Node left;

    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    /**
     * 在子树下添加根节点
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断要添加的节点比根节点的值小放左节点，否则放右节点
        if (node.value < this.value) {
            //子树的左节点为空添加节点
            if (this.left == null) {
                this.left = node;
            //否则继续查找左节点
            } else {
                this.left.add(node);
            }
        //子树添右节点加节点
        } else {
            if (this.right == null) {
                this.right = node;
            //查找右节点的下一个节点
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历二叉排序树
     */
    public void middleShow() {
        if (this.left != null) {
            this.left.middleShow();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.middleShow();
        }
    }

    /**
     * 查找二叉排序树的节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;
        } else if (this.left != null && this.value > value) {
            return this.left.searchParent(value);
        } else if (this.right != null && this.value < value) {
            return this.right.searchParent(value);
        }
        return null;
    }
}

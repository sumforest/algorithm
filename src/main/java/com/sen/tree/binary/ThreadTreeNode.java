package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 01:04
 * @Description: 线索二叉树的节点
 */
public class ThreadTreeNode {

    /**
     * 树的权
     */
    private int value;

    /**
     * 左子树
     */
    private ThreadTreeNode leftNode;

    /**
     * 右子树
     */
    private ThreadTreeNode rightNode;
    /**
     * 左节点的类型(默认为1，线索化后为2)
     */
    private int leftType;

    /**
     * 右节点的类型(默认为1，线索化后为2)
     */
    private int rightType;

    public ThreadTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * 前序遍历
     */
    public void preShow() {
        System.out.print(this.value+",");
        if (this.leftNode != null) {
            this.leftNode.preShow();
        }
        if (this.rightNode != null) {
            this.rightNode.preShow();
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        if (this.leftNode != null) {
            this.leftNode.middleShow();
        }
        System.out.print(this.value+",");
        if (this.rightNode != null) {
            this.rightNode.middleShow();
        }
    }

    /**
     * 后续遍历
     */
    public void afterShow() {
        if (this.leftNode != null) {
            this.leftNode.afterShow();
        }
        if (this.rightNode != null) {
            this.rightNode.afterShow();
        }
        System.out.print(this.value+",");
    }

    public void setLeftNode(ThreadTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(ThreadTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public ThreadTreeNode getLeftNode() {
        return leftNode;
    }

    public ThreadTreeNode getRightNode() {
        return rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    /**
     * 前序查找
     * @param i 目标权
     * @return 目标节点
     */
    public ThreadTreeNode preSearch(int i) {
        //定义用于返回的节点
        ThreadTreeNode node = null;
        //根节点为目标节点直接返回
        if (this.value == i) {
            return this;
        //向子节点查找
        } else {
            //向左节点查找
            if (this.leftNode != null) {
                node = this.leftNode.preSearch(i);
            }
            //如果找到node != null说明已找到
            if (node != null) {
                return node;
            }
            //向右节点查找
            if (this.rightNode != null) {
                node = this.rightNode.preSearch(i);
            }
        }
        return node;
    }

    /**
     * 删除一个节点
     *
     * @param i
     */
    public void delete(int i) {
        //检查左节点
        if (this.leftNode != null && this.leftNode.value == i) {
            this.leftNode = null;
            return;
        }
        //检查右节点
        if (this.rightNode != null && this.rightNode.value == i) {
            this.rightNode = null;
            return;
        }
        //递归查找并删除左子节点
        if (this.leftNode != null) {
            this.leftNode.delete(i);
        }
        //递归查找并删除右子节点
        if (this.rightNode != null) {
            this.rightNode.delete(i);
        }
    }
}

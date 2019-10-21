package com.sen.tree.avl;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 00:28
 * @Description: 平衡二叉树的节点
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

        //判断添加节点后的二叉排序树是否为平衡二叉树
        //右旋转
        if (this.left != null && this.right != null && this.left.getHight() - this.right.getHight() > 1) {
            //先左旋转再右旋转
            if (this.left.left != null && this.left.left.getHight() < this.left.right.getHight()) {
                this.left.leftRotate();
                this.rightRotate();
            } else {
                this.rightRotate();
            }
        }
        //左旋转
        if (this.left != null && this.right != null && this.left.getHight() - this.right.getHight() < -1) {
            //先右旋转再左旋转
            if (this.right.right != null && this.right.right.getHight() < this.right.left.getHight()) {
                this.right.rightRotate();
                this.leftRotate();
            } else {
                this.leftRotate();
            }
        }
    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        Node newLeft = new Node(this.value);
        newLeft.left = this.left;
        newLeft.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newLeft;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        //把当前节点取出来作为新的右子树根节点
        Node newRight = new Node(this.value);
        //把当前节点的右节点取出来有位新的右节点的右节点
        newRight.right = this.right;
        //把当前节点的左节点作为新右节点的左节点
        newRight.left = this.left.right;
        //把左节点的值赋给当前节点
        this.value = this.left.value;
        //把当前节点的左节点的左节点最为当前节点的左节点
        this.left = this.left.left;
        //新的右子树根节点作为当前节点的右节点
        this.right = newRight;
    }

    /**
     * 获取当前子树的高度
     * @return
     */
    public int getHight() {
        return Math.max(this.left == null ? 0 : this.left.getHight(),
                this.right == null ? 0 : this.right.getHight()) + 1;
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
        if (this.left != null && this.left.value == value ||
                this.right != null && this.right.value == value) {
            return this;
        } else if (this.left != null && this.value > value) {
            return this.left.searchParent(value);
        } else if (this.right != null && this.value < value) {
            return this.right.searchParent(value);
        }
        return null;
    }
}

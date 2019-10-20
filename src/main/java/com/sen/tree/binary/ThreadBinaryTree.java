package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 01:03
 * @Description: 中序线索二叉树
 */
public class ThreadBinaryTree {

    /**
     * 根节点
     */
    private ThreadTreeNode rootNode;

    /**
     * 用于存储前一个节点的临时变量
     */
    private ThreadTreeNode preNode;

    public ThreadTreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(ThreadTreeNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 构建线索二叉树
     */
    public void threadNodes() {
        threadNodes(rootNode);
    }

    /**
     * 构建线索二叉树(中序线索二叉树)
     * @param node
     */
    public void threadNodes(ThreadTreeNode node) {
        //递归退出条件
        if (node == null) {
            return;
        }
        //处理左子树
        threadNodes(node.getLeftNode());
        //处理当前节点的做指针
        if (node.getLeftNode() == null) {
            //左节点指向前一个节点
            node.setLeftNode(node);
            //左指针类型修改为1
            node.setLeftType(1);
        }
        //处理当前节点的前一个节点的右指针
        if (preNode != null && preNode.getRightNode() == null) {
            //把前一个节点的右指针指向当前节点
            preNode.setRightNode(node);
            //右指针类型修改为1
            preNode.setRightType(1);
        }
        //保存上一个节点
        preNode = node;
        //处理右子树
        threadNodes(node.getRightNode());
    }

    /**
     * 遍历线索二叉树
     */
    public void threadBinaryTreeShow() {
        //用于临时存储当前遍历的节点
        ThreadTreeNode node = rootNode;
        //遍历所有节点
        while (node != null) {
            //遍历左节点
            while (node.getLeftType() == 0) {
                node = node.getLeftNode();
            }
            System.out.println(node.getValue());
            while (node.getRightType() == 1) {
                node = node.getRightNode();
                System.out.println(node.getValue());
            }
            //替换当前遍历的node
            node = node.getRightNode();
        }
    }

    /**
     * 前序遍历
     */
    public void preShow() {
        if (rootNode != null) {
            rootNode.preShow();
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        if (rootNode != null) {
            rootNode.middleShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow() {
        if (rootNode != null) {
            rootNode.afterShow();
        }
    }

    /**
     * 前序查找
     * @param i 目标数据
     * @return
     */
    public  ThreadTreeNode preSearch(int i) {
        return rootNode.preSearch(i);
    }

    /**
     * 删除一个节点
     * @param i
     */
    public void delete(int i) {
        //如果是根节点直接删除
        if (this.rootNode.getValue() == i) {
            this.rootNode = null;
        //查找子节点
        } else {
            rootNode.delete(i);
        }
    }

}

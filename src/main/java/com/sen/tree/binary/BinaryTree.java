package com.sen.tree.binary;

/**
 * @Auther: Sen
 * @Date: 2019/10/19 01:03
 * @Description: 二叉树
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private TreeNode rootNode;


    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
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
    public  TreeNode preSearch(int i) {
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

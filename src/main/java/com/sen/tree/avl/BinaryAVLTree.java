package com.sen.tree.avl;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 00:28
 * @Description: 平衡二叉树 每个节点的左子树和右子树的高度绝对值差值不大于1
 */
public class BinaryAVLTree {

    private Node rootNode;

    public BinaryAVLTree() {
    }

    public BinaryAVLTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 往二叉排序树添加节点
     * @param node
     */
    public void add(Node node) {
        if (rootNode == null) {
            rootNode = node;
        } else {
            rootNode.add(node);
        }
    }

    /**
     * 中序遍历二叉排序树
     */
    public void middleShow() {
        if (rootNode == null) {
            return;
        }
        rootNode.middleShow();
    }

    /**
     * 查找二叉树的节点
     * @param value 节点的值
     * @return
     */
    public Node search(int value) {
        if (rootNode == null) {
            return null;
        }
        return rootNode.search(value);
    }

    /**
     * 删除节点
     * 1.删除的节点是叶子节点
     * 2.删除节点只有一个叶子节点的非叶子节点
     * 3.删除几点有两个叶子节点的非叶子节点即用被删除的前驱节点或者后继节点替换它本身
     * @param value 要删除节点的权
     */
    public void delete(int value) {
        if (rootNode == null) {
            return;
        }

        //查找要删除的节点
        Node target = search(value);
        //查找要删除节点的父节点
        Node parent = searchParent(value);
        if (target == null) {
            return;
        }

        //删除的是叶子节点
        if (target.getLeft() == null && target.getRight() == null) {

            //删除的是左节点
            if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                parent.setLeft(null);
            }else {
                parent.setRight(null);
            }
        //删除的是有两个子节点的非叶子节点
        } else if (target.getLeft() != null && target.getRight() != null) {

            //删除该节点右子树中最小的节点并返回最小节点的值
            int min = deleteMinNode(target.getRight());
            //替换目标节点的值
            target.setValue(min);
        //删除只有一个左节点或者一个右节点的节点
        } else {

            //被删除的节点有左节点
            if (target.getLeft() != null) {
                if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    parent.setLeft(target.getLeft());
                }else {
                    parent.setRight(target.getLeft());
                }
            //被删除的节点有右节点
            }else{
                if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                    parent.setLeft(target.getRight());
                }else {
                    parent.setRight(target.getRight());
                }
            }
        }
    }

    /**
     * 删除最小的节点
     * @param node
     * @return
     */
    private int deleteMinNode(Node node) {
        Node target = node;
        //循环查找左节点
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        delete(target.getValue());
        return target.getValue();
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (rootNode == null) {
            return null;
        }
        return rootNode.searchParent(value);
    }
}

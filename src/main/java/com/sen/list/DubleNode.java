package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 16:54
 * @Description: 双向循环链表
 */
public class DubleNode {

    /**
     * 上一个节点
     */
    private DubleNode pre;

    /**
     * 下一个节点
     */
    private DubleNode next;

    private int data;

    public DubleNode(int data) {
        this.pre = this;
        this.next = this;
        this.data = data;
    }

    /**
     * 在节点后面添加新节点
     * @param node
     */
    public void after(DubleNode node) {
        //获取当前节点的下一个节点
        DubleNode newNext = this.next;
        //当前节点的下一个节点指向新节点
        this.next = node;
        //新节点的上一个节点执行当前节点
        node.pre = this;
        //新节点的下一个节点指向当前节点的下一个节点
        node.next = newNext;
        //当前节点的下一个节点的前一个节点指向新节点
        newNext.pre = node;
    }

    public DubleNode next() {
        return this.next;
    }

    public DubleNode pre() {
        return this.pre;
    }

    public int getData() {
        return this.data;
    }
}

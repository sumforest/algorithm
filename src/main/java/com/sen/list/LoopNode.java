package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 15:12
 * @Description: 循环链表
 */
public class LoopNode {
    /**
     * 当前节点的值
     */
    private int data;

    /**
     * 下一个节点
     */
    private LoopNode next;

    public LoopNode(int data) {
        this.data = data;
        this.next = this;
    }

    /**
     * 追加下一个节点
     * @param target 下一个节点
     * @return 追加节点后的节点
     */
    public LoopNode append(LoopNode target) {
        //当前节点
       LoopNode currentNode = this;
        while (true) {
            //获取下一个节点
            LoopNode nextNode = currentNode.next;
            //如果下一个节点为空，则当前节点是要追加节点的节点
            if (nextNode == this) {
                break;
            }
            //把下一个节点赋值给当前节点
            currentNode = nextNode;
        }
        currentNode.next = target;
        return currentNode;
    }

    /**
     * 删除下一个节点
     * 因为是单链表所以只记录了下一个节点的信息，无法找到上一个节点的信息
     */
    public void deleteNextNode() {
        //获取当前节点的下下个节点
        LoopNode newNext = this.next.next;
        //把当前节点的下下个节点赋值给当前节点的下一个节点
        this.next = newNext;
    }

    /**
     * 在节点后面插入一个新节点
     * @param node
     */
    public void insert(LoopNode node) {
        //取出当前节点的下个节点
        LoopNode newNext = this.next;
        //把要插入的节点给当前节点的下一个节点
        this.next = node;
        //把当前节点的下个节点给新节点的下一个节点
        node.next = newNext;
    }


    /**
     * 获取下一个节点的值
     * @return
     */
    public int getData() {
        return this.data;
    }

    public LoopNode getNext() {
        return this.next;
    }
}

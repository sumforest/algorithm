package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 15:12
 * @Description: 单链表
 */
public class Node {
    /**
     * 当前节点的值
     */
    private int data;

    /**
     * 下一个节点
     */
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 追加下一个节点
     * @param target 下一个节点
     * @return 追加节点后的节点
     */
    public Node append(Node target) {
        //当前节点
       Node currentNode = this;
        while (true) {
            //获取下一个节点
            Node nextNode = currentNode.next;
            //如果下一个节点为空，则当前节点是要追加节点的节点
            if (nextNode == null) {
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
        Node newNext = this.next.next;
        //把当前节点的下下个节点赋值给当前节点的下一个节点
        this.next = newNext;
    }

    /**
     * 在节点后面插入一个新节点
     * @param node
     */
    public void insert(Node node) {
        //取出当前节点的下个节点
        Node newNext = this.next;
        //把要插入的节点给当前节点的下一个节点
        this.next = node;
        //把当前节点的下个节点给新节点的下一个节点
        node.next = newNext;
    }

    /**
     * 打印所有的节点信息
     */
    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.next;
            //如果当前节点是最后一个节点
            if (currentNode == null) {
                break;
            }
        }
        System.out.println();
    }

    /**
     * 获取下一个节点
     * @return
     */
    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    /**
     * 判断当前节点是否为最后一个节点
     * @return
     */
    public boolean isLastNode() {
        return this.next == null;
    }
}

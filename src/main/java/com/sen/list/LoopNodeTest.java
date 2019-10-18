package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 16:27
 * @Description:
 */
public class LoopNodeTest {
    public static void main(String[] args) {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        // System.out.println(n4.getNext().getData());
        n1.insert(n2);
        n2.insert(n3);
        n3.insert(n4);
        System.out.println(n1.getNext().getData());
        System.out.println(n2.getNext().getData());
        System.out.println(n3.getNext().getData());
        System.out.println(n4.getNext().getData());
    }
}

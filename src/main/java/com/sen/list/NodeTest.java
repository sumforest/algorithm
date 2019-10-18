package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 15:28
 * @Description:
 */
public class NodeTest {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.append(n2).append(n3).append(new Node(4));
        // System.out.println(n1.getNext().getNext().getNext().getData());
        n1.show();
        // n1.getNext().deleteNextNode();
        Node node = new Node(5);
        n1.getNext().insert(node);
        n1.show();
    }
}

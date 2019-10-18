package com.sen.list;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 17:05
 * @Description: 双向循环列表
 */
public class DubleNodeTest {
    public static void main(String[] args) {
        DubleNode n1 = new DubleNode(1);
        DubleNode n2 = new DubleNode(2);
        DubleNode n3 = new DubleNode(3);
        DubleNode n4 = new DubleNode(4);

        n1.after(n2);
        n2.after(n3);
        n3.after(n4);
        System.out.println(n4.pre().getData());
        System.out.println(n4.getData());
        System.out.println(n4.next().getData());
    }
}

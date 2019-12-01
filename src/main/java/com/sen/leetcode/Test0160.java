package com.sen.leetcode;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/11/30 02:48
 * @Description: 相交链表
 */
public class Test0160 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);
        headA.next.next = commonNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        while(currentNodeA != null){
            currentNodeB = headB;
            while(currentNodeB != null){
                if(currentNodeA == currentNodeB){
                    return new ListNode(currentNodeA.val);
                }
                currentNodeB = currentNodeB.next;
            }
            currentNodeA = currentNodeA.next;
        }
        return null;
    }
}

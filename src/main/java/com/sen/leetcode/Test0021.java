package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/11/24 23:18
 * @Description:
 */
public class Test0021 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        // l2.next.next = new ListNode(4);
        // ListNode listNode = mergeTwoLists(l1, l2);
        ListNode listNode = mergeTwoLists2(l1, l2);
        System.out.println(1);
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2:l1;

        return preHead.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode2 = l2;

        //遍历链表2
        while(currentNode2 != null){
            ListNode currentNode = l1;
            while(currentNode != null){
                //当前节点处于新链表的中间
                if(currentNode.val < currentNode2.val && currentNode.next != null && currentNode.next.val >= currentNode2.val){
                    ListNode temp = currentNode.next;
                    currentNode.next = new ListNode(currentNode2.val);
                    currentNode.next.next = temp;
                    break;
                    //当前节点处于链表的末尾
                }else if(currentNode.val <= currentNode2.val && currentNode.next == null){
                    currentNode.next = new ListNode(currentNode2.val);
                    break;
                    //当前节点处于新链表的前面
                }else if(currentNode.val >= currentNode2.val){
                    ListNode listNode = new ListNode(currentNode2.val);
                    listNode.next = currentNode;
                    l1 = listNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            currentNode2 = currentNode2.next;
        }
        return l1;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}


package com.company.DSA.LinkList;

import com.company.DSA.LinkList.pojo.ListNode;

import static java.lang.System.*;

//https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        if (head==null || head.next == null){
            return head;
        }

        ListNode temp = new ListNode(0, new ListNode());

        while (head.next!=null){
            temp.val = head.next.val;
            temp.next.val = head.val;
            temp = new ListNode(0, temp);
            head = head.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2));
        out.println(reverseList(head).toString());
    }
}

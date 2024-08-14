package com.company.DSA.LinkList;

import com.company.DSA.LinkList.pojo.ListNode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {

        if (head==null || head.next == null){
            return head;
        }
        ListNode cur = new ListNode(head.val, head.next);
        ListNode dummy = cur;

        while (cur!=null && cur.next!=null){

            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(deleteDuplicates(head).toString());
    }
}

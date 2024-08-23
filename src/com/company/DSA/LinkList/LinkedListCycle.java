package com.company.DSA.LinkList;

import com.company.DSA.LinkList.pojo.ListNode;

//https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(slow!=null && fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode head= new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= head.next;
        System.out.println(hasCycle(head));
    }
}

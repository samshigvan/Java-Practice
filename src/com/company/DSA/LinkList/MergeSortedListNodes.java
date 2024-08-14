package com.company.DSA.LinkList;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeSortedListNodes {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode dummy = cur;

        while (l1 != null && l2 != null){

            if (l1.val>l2.val){
                cur.next = l2;
                l2=l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(list1, list2));
    }
}

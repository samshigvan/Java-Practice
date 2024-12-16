package com.company.DSA.LinkList;

import com.company.DSA.LinkList.pojo.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int carry =0;
        int total =0;

        while (l1 != null || l2 != null || carry != 0){

            total = carry;

            if (l1 != null){
                total = total + l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                total = total + l2.val;
                l2 = l2.next;
            }

            int num = total %10;
            carry = total /10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return res.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(addTwoNumbers(l1, l2));
    }
}

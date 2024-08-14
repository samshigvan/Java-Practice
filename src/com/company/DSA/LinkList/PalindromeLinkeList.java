package com.company.DSA.LinkList;

import com.company.DSA.LinkList.pojo.ListNode;

import static java.lang.System.*;

public class PalindromeLinkeList {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null){
            return true;
        }

        ListNode l1 = head;
        ListNode l2 = head;

        while (l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
        }

        ListNode reversed = new ListNode(0, new ListNode());

        while (l1.next!=null){
            reversed.val = l1.next.val;
            reversed.next.val = l1.val;
            reversed = new ListNode(0, reversed);
            l1=l1.next;
        }
        reversed = reversed.next;

        while (head!=null && reversed!=null){

            if (head.val != reversed.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head){

        ListNode reversed = new ListNode(0, new ListNode());
        ListNode temp = new ListNode(head.val, head.next);

        if (head == null || head.next == null){
            return true;
        }

        while (head.next!=null){
            reversed.val = head.next.val;
            reversed.next.val = head.val;
            reversed = new ListNode(0, reversed);
            head = head.next;
        }
        reversed = reversed.next;
        while (reversed!=null){

            if (reversed.val != temp.val){
                return false;
            }
            reversed =reversed.next;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        [1,2,2,1]
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
//        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
//        ListNode head = new ListNode(1);
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(1)))));
        out.println(isPalindrome(head));
    }
}

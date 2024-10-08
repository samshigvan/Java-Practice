package com.company.DSA.LinkList.pojo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){ this.val = val;}
    public ListNode(int val, ListNode next){ this.val = val; this.next = next;}

    @Override
    public String toString() {
        String temp = val + " ";
        if (next!=null){
            temp+= next.toString();
        }
        return temp;
    }
}
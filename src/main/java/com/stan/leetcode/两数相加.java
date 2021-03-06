package com.stan.leetcode;

/**
 * 2018-10-12
 */
public class 两数相加 {
    public static void main(String[] args){

        /*
            给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

            你可以假设除了数字 0 之外，这两个数字都不会以零开头。

            示例：

            输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
            输出：7 -> 0 -> 8
            原因：342 + 465 = 807
         */


        ListNode l1Head=new ListNode(0);
        ListNode l1=l1Head;


        l1.next=new ListNode(1);
        l1=l1.next;
        l1.next=new ListNode(2);
        l1=l1.next;
        l1.next=new ListNode(3);
        l1=l1.next;


        ListNode l2Head=new ListNode(0);

        ListNode l2=l2Head;

        l2.next=new ListNode(5);
        l2=l2.next;
        l2.next=new ListNode(6);
        l2=l2.next;



        ListNode result=addTwoNumbers(l1Head.next,l2Head.next);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

//        ListNode temp=l1;






    }

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode h1 = l1, h2 = l2;
        ListNode curr = dummy;
        int carry = 0;

        while (h1 != null || h2 != null) {
            int n1 = h1 == null? 0 : h1.val;
            int n2 = h2 == null? 0 : h2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            //迭代
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
            curr = curr.next;
        }
        if (carry != 0) curr.next = new ListNode(1);
        return dummy.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
     val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
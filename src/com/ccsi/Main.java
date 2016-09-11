package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    ListNode head=buildLinkedList();
        boolean b=isPalindrome(head);
        System.out.println(b);
    }
    public static ListNode buildLinkedList(){
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(2);
        root.next.next.next.next=new ListNode(1);
        //root.next.next.next.next.next=new ListNode(1);
        return root;
    }

    public static boolean isPalindrome(ListNode head){
        if(head==null) return false;
        if(head.next==null) return true;
        ListNode mid=findMidNode(head);
        ListNode after=reverseLinkedList(mid.next);     //从mid.next开始新建一linked list并逆序。
        ListNode pre=head;
        ListNode next=after;

        while(pre!=null&&next!=null){
            if(pre.val!=next.val) return false;
            pre=pre.next;
            next=next.next;
        }
        return true;

    }

    public static ListNode findMidNode(ListNode head){
        if(head==null) return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){                    //只要判断快指针的当前与next是否为空，慢指针肯定不会为空
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseLinkedList(ListNode head){    //此方法更简洁，更容易理解
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }

        return prev;
    }

}
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

package com.riveryoung.leetcode.interview.oppo;

import java.util.Stack;

public class oppo {
    public static void main(String[] args){
        System.out.println("hello");

    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //反转链表
    ListNode reverseList(ListNode root){
        if (root == null || root.next == null){
            return root;
        }

        ListNode prev = null;
        ListNode cur = root;
        ListNode end = root.next;
        while(end != null){
            cur.next = prev;
            cur = prev;
            prev = end;
            end = prev.next;
        }
        return prev;
    }

    ListNode reverseList_stack(ListNode root){
        if (root == null || root.next == null){
            return root;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = null;
        while(root != null){
            temp.val = root.val;
            stack.push(temp);
            root = root.next;
        }

        ListNode head;
        temp = stack.pop();
        head = temp;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
        }
        return head;
    }

    //删除单链表倒数第k个结点
    ListNode deleteKNode(ListNode root, int k){
        ListNode p1 = root;
        ListNode pK = root;
        ListNode prev = null;
        for (int i = 1; i < k && pK != null; i++){
            pK = pK.next;
        }

        if (pK != null){
            while(pK != null){
                prev = p1;
                p1 = p1.next;
                pK = pK.next;
            }
            prev.next = p1.next;
        }
        return root;
    }
}

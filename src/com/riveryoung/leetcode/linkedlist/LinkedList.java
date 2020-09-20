package com.riveryoung.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Stack;

/**
 *  常见的链表操作
 *
 * @author www.riveryoung.cn
 * @since  2020-9-21 01:23:52
 * */
public class LinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表 - 解决方案
     **/
    public int[] reversePrint(ListNode head){
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        int len = stack.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     *  剑指 Offer 18. 删除链表的节点
     * */
    public ListNode deleteNode(ListNode head, int value) {
        if (head == null){
            return null;
        }
        if (head.val == value){
            return head.next;
        }

        ListNode post = head;
        ListNode pre = head.next;
        while(pre != null && pre.val != value){
            post = pre;
            pre = pre.next;
        }
        if (pre != null){
            post.next = pre.next;
        }
        return head;
    }

    /**
     *  剑指 Offer 22. 链表中倒数第 k 个节点
     *  方法一： 两次遍历
     * */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int length = 1;
        ListNode result = head;
        while(head.next != null){
            length++;
            head = head.next;
        }

        int cnt = length - k;
        for (int i = 0; i < cnt; i++){
            if (result.next != null){
                result = result.next;
            }
        }
        return result;
    }

    /**
     *  剑指 Offer 22. 链表中倒数第 k 个节点
     *  方法二： 双指针
     * */
    public ListNode getKthFromEnd_b(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode post = head;
        ListNode prev = head;
        for(int i = 0; i < k; i++) {
            if(prev != null){
                prev = prev.next;
            }
        }
        while(prev != null){
            post = post.next;
            prev = prev.next;
        }
        return post;
    }

    /**
     *  剑指 Offer 24. 反转链表
     *  */
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode prev = head;
        ListNode temp;
        while (prev != null){
            temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        return cur;
    }

    /**
     *  剑指 Offer 25. 合并两个排序的链表
     *  方法一： 先找头结点，然后排序合并
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //1、找到头结点，并记录
        ListNode temp = null;
        ListNode result = null;
        if (l1.val <= l2.val){
            temp = l1;
            l1 = l1.next;
        }else {
            temp = l2;
            l2 = l2.next;
        }
        result = temp;
        //2、重新排序l1和l2，并入temp
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return result;
    }

    /**
     *  剑指 Offer 25. 合并两个排序的链表
     *  方法二： 递归法
     * */
    public ListNode mergeTwoLists_b(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists_b(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_b(l1, l2.next);
            return l2;
        }
    }

    /**
     *  剑指 Offer 52. 两个链表的第一个公共节点
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}



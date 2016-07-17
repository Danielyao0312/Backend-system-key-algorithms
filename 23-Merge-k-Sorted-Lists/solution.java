/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
using divide and conquer:
1. divide into two part;
2. merge left part to list a
3. merge right part to list b
4. merge a and b.
*/ 

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
                p = p.next;
            } else {
                p.next = h2;
                h2 = h2.next;
                p = p.next;
            }
        }
        if (h1 != null) {
            p.next = h1;
        } else {
            p.next = h2;
        }
        
        return dummy.next;
    }
}
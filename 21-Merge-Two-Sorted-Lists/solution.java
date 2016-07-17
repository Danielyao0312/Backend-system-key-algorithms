/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
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
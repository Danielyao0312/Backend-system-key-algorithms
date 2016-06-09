/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pa = headA, pb = headB;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        int dislen = lenA > lenB ? lenA - lenB : lenB - lenA;
        

        for (int i = 0; i < dislen; i++) {
            if (lenA > lenB) {
                pa = pa.next;
            } else {
                pb = pb.next;
            }
        }
        
        while (pa != null && pb != null) {
            if(pa.val == pb.val)    break;
            pa = pa.next;
            pb = pb.next;
        }
        
        return pa;
    }
    
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len ++;
        }
        return len;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = dummy, q = dummy;
        
        for (int i = 0; i < m - 1; i++) {
            p = p.next; // p point to 1 
        }
        for (int i = 0; i < n; i++) {
            q = q.next; //q point to 4;
        }
        
        ListNode temp1 = q.next;
        ListNode temp2 = p.next;
        q.next = null;
        p.next = reverse(p.next);
        temp2.next = temp1;
        
        return dummy.next;
    }
    
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int val = pre.next.val;
                while (pre.next != null && pre.next.val == val) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        
        return dummy.next;
    }
}
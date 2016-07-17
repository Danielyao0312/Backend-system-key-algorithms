/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
//  while loop version;    
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode post = head.next;
        
        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }

// recursion version;    
    // public ListNode reverseList(ListNode head) {
        
    //     if(head == null){
    //         return head;
    //     }
    //     //base case
    //     if(head.next == null){
    //         return head;
    //     }
    //     //recursively solve the subproblem
    //     ListNode newHead = reverseList(head.next);
        
    //     //combine sub to original problem
    //     head.next.next = head;
    //     head.next = null;
        
    //     return newHead;
    // }
    
        
    
}
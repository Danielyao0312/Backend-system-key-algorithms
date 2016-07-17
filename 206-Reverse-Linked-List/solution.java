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
        
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
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
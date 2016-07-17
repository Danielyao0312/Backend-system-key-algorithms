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
    // public ListNode reverseList(ListNode head) {
    //     if(head == null) return null;
    
    //     ListNode start = head;
    //     ListNode curr = head.next;
    //     ListNode after = null;
        
    //     start.next = null;//把第一个点的 next 断开
    //     while(curr != null){
    //         after = curr.next;
    //         curr.next = start;
    //         start = curr;
    //         curr = after;
            
    //     }
    //     return start;
    // }

// recursion version;    
    public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return head;
        }
        //base case
        if(head.next == null){
            return head;
        }
        //recursively solve the subproblem
        ListNode newHead = reverseList(head.next);
        
        //combine sub to original problem
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
        
    
}
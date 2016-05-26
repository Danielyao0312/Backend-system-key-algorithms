/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * 
 * }
 */
public class Solution {
    //how to solve: first round, go through the linked list, get the length : len
    //run len - k steps, 1->2->3->null   4->5->
    public ListNode rotateRight(ListNode head, int k) {
        //corner cases:
        if(k == 0 || head == null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        //get the length of the list
        int len = 0;
        ListNode p = dummy;
        while(p.next != null){
            len++;
            p = p.next;
        }
        
        ListNode q = dummy;
        //stop at k position
        for(int i = len - k % len; i > 0; i--){
            q = q.next;
        }
        
        //connect the first and second part of the list
        p.next=dummy.next; //Do the rotation
        dummy.next=q.next;
        q.next=null;
        
        return dummy.next;
    }
}
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
                    
        use merge sort;
     */
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next; // key point!!!  fast must initial = head.next, otherwise the program will stack overflow.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode c = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                c.next = h1;
                h1 = h1.next;
            } else {
                c.next = h2;
                h2 = h2.next;
            }
            c = c.next;
        }
        if (h1 != null) {
            c.next = h1;
        } else {
            c.next = h2;
        }
        return dummy.next;
    }
     
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
        
    }
}
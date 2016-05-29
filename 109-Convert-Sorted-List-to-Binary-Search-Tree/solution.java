/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // use top down (pre order solution)
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    
    private TreeNode helper(ListNode head) {
        //base case:
        if(head == null)    return null;
        if(head.next == null)   return new TreeNode(head.val);
        
        //use slow and fast pointer to find the root node
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null; 
        while(fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        ListNode rightList = slow.next;
        // slow.next = null;
        pre.next = null;
        
        root.left = helper(head);
        root.right = helper(rightList);
        
        return root;
    }
}
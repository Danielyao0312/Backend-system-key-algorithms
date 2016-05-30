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
    // solution 1:  use top down (pre order solution) (fast and slow pointer)
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        //base case:
        if(start == end)    return null;
        
        ListNode fast = start;
        ListNode slow = start;
        
        while(fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(start, slow);
        root.right = sortedListToBST(slow.next, end);
        
        return root;
    }
    
}
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
    
    private ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        int len = getLength(head);
        
        cur = head;
        TreeNode root = buildTree(len);
        return root;
    }
    
    private TreeNode buildTree(int n) {
        if(n == 0)      return null;
        TreeNode root = new TreeNode(0);
        root.left = buildTree(n / 2);
        root.val = cur.val;
        cur = cur.next;
        root.right = buildTree(n - n / 2 - 1);
        return root;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}
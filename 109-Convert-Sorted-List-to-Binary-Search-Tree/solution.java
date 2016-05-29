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
        //base case:
        if(head == null)    return null;
        if(head.next == null)   return new TreeNode(head.val); // 出错点 : 建立个树点， 重要！
        
        //use slow and fast pointer to find the root node
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null; 
        while(fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 此时 slow 指向的是中间的那个点，以他为核心建立 root, 然后，左边的 linked list 建立左子树，右边的建立右子树
        TreeNode root = new TreeNode(slow.val);
        ListNode rightList = slow.next;
        slow.next = null;
        pre.next = null;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightList);
        
        return root;
    }
}
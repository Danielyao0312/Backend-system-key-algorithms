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
    // // solution 1:  use top down (pre order solution) (fast and slow pointer)
    // public TreeNode sortedListToBST(ListNode head) {
    //     return sortedListToBST(head, null);
    // }
    
    // private TreeNode sortedListToBST(ListNode start, ListNode end) {
    //     //base case:
    //     if(start == end)    return null;
        
    //     ListNode fast = start;
    //     ListNode slow = start;
        
    //     while(fast != end && fast.next != end) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
        
    //     TreeNode root = new TreeNode(slow.val);
    //     root.left = sortedListToBST(start, slow);
    //     root.right = sortedListToBST(slow.next, end);
        
    //     return root;
    // }
    
    /**class Solution {
        public:
            TreeNode *sortedListToBST(ListNode *head) {
                int listLen = 0;
                ListNode *cur = head;
                while(cur) {
                    listLen++;
                    cur = cur->next;
                }
                return sortedListToBST(head, 0, listLen-1);
            }
            
            TreeNode *sortedListToBST(ListNode *&head, int start, int end) {
                if(start>end) return NULL;
                int mid = start + (end-start)/2;
                TreeNode *leftChild = sortedListToBST(head, start, mid-1);
                TreeNode *root = new TreeNode(head->val);
                head = head->next;
                TreeNode *rightChild = sortedListToBST(head, mid+1, end);
                root->left = leftChild;
                root->right = rightChild;
                return root;
            }
        };
    */
    
// solution 2:    
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
        TreeNode root = new TreeNode(-999);
        root.left = buildTree(n / 2);
        root.val = cur.val;
        cur = cur.next;  // !!! key point
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
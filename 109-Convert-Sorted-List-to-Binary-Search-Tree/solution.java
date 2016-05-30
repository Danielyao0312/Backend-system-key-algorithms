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
    
    
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len ++;
            cur = cur.next;
        }
        ListNode[] chead = new ListNode[1]; // 用数组，解决了 java 中copy by value 的问题
        chead[0] = head;
        return build(chead, 0, len - 1);
    }
    
    private TreeNode build(ListNode[] chead, int start, int end) {
        if(start > end)     return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = build(chead, start, mid - 1);
        TreeNode root = new TreeNode(chead[0].val);
        chead[0] = chead[0].next;
        TreeNode right = build(chead, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    
}
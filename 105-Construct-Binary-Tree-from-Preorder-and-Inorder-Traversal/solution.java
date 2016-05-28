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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        TreeNode res = helper(preorder, 0, preEnd, inorder, 0, inEnd);
        return res;
    }
    
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //corner case:
        if(preStart > preEnd || inStart > inEnd)    return null;
        
        int rootVal = pre[preStart];
        int pos = 0;    //root index in the inorder array
        for(int i = inStart; i <= inEnd; i++) {
            if(rootVal == in[i]){
                pos = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(pre, preStart + 1, preStart + pos - inStart, in, inStart, pos - 1);
        root.right = helper(pre, preStart + pos - inStart + 1, preEnd, in, pos + 1, inEnd);
        
        return root;
        
    }
}
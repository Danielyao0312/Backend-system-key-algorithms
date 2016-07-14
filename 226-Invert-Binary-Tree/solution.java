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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        // divide:
        TreeNode aa = invertTree(root.left);
        TreeNode bb = invertTree(root.right);
        
        // conquer:
        TreeNode temp = root.left; // left == 2, temp = 2
        root.left = root.right; // 
        root.right = temp;
        
        
        return root;
    }
}
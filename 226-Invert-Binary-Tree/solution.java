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
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        // conquer:
        // TreeNode temp = root.left; // left == 2, temp = 2
        // root.left = root.right; // 
        // root.right = temp;
        
        
        return root;
    }
}
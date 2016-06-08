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
    
    private long lastVisited = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        
        if(!isValidBST(root.left))      return false;
        
        if(root.val <= lastVisited)     return false;
        lastVisited = root.val;
        
        if(!isValidBST(root.right))      return false;
        
        return true;
    }
}
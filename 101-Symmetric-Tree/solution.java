/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /*判断左右子树是否相等。*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }
    
    private boolean isSymmetricTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if( (p == null && q != null) || (p != null && q == null) ) return false;
        
        return (p.val == q.val) && (isSymmetricTree(p.left, q.right)) && (isSymmetricTree(p.right, q.left));
        
    }
}
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
    
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
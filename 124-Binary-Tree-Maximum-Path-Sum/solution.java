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
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode x) {
        if (x == null)  return 0;
        int left = findMax(x.left);
        int right = findMax(x.right);
        maxSum = Math.max(x.val + left + right, maxSum);
        int ret = x.val + Math.max(left, right);
        return (ret > 0) ? ret : 0;
    }
    
}
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        //leaf or null
        if(root == null){
            return result;
        }
        
        //divide
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        //add together:
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        
        return result;
    }
}
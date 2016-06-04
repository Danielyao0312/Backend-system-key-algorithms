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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)    return null;
        TreeNode lastLeftTurned = null;
        TreeNode parent = root;
        
        while(parent.val != p.val) {
            if(parent == null)  return lastLeftTurned;
            if(p.val < parent.val) {
                lastLeftTurned = parent;
                parent = parent.left;
            }else {
                parent = parent.right;
            }
        }

        if(parent.right != null) {
            return findMin(parent.right);
        }else{
            return lastLeftTurned;
        }
    }

    private TreeNode findMin(TreeNode root) {
        if(root == null)    return null;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(list, root);
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }
    
    private void inorder(ArrayList<Integer> list, TreeNode root) {
        if(root == null)    return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
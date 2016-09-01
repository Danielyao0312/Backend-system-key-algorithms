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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        helper(res, path, root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {

        if(root.left == null && root.right == null) {     //meet root point
            if (sum - root.val == 0) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        
        path.add(root.val);
        if(root.right != null) { 
            helper(res, path, root.right, sum - root.val);
        }
        if (root.left != null) {
            helper(res, path, root.left, sum - root.val);
        }
        path.remove(path.size() - 1);
    }
}
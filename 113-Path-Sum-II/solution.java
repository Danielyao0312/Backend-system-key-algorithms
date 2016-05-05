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
        
        dfs(res, path, root, sum);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum){
        if(root == null) return;
        
        sum -= root.val;
        
        if(root.left == null && root.right == null){
            if(sum == 0){
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        
        path.add(root.val);
        dfs(res, path, root.left, sum);
        dfs(res, path, root.right, sum);
        path.remove(path.size() - 1);
    }
}
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
    //BFS traverse the tree, maintain a flag called reverse = false initially, change it to true when go to the next level
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)    return res;
        
        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subres = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null)    q.add(cur.left);
                if(cur.right != null)   q.add(cur.right);
                subres.add(cur.val);
            }
            
            if(reverse == false) {
                res.add(subres);
                reverse = true;
            }else{
                Collections.reverse(subres);
                res.add(subres);
                reverse = false;
            }
        }
        
        return res;
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
 		List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
 		
 		if(root == null) {
 		    return res;
 		}
 		
 		q.add(root);
 		while(!q.isEmpty()) {
 			List<Integer> subres = new ArrayList<>();
 			
            int size = q.size();
 			for(int i = 0; i < size; i++) {
 				TreeNode cur = q.poll();
 				subres.add(cur.val);

 				if (cur.left != null)	q.add(cur.left);
 				if (cur.right != null)	q.add(cur.right);
 			}

 			res.add(subres);
 		}

 		return res;
    }
}
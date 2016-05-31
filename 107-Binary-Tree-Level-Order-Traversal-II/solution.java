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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
 		List<List<Integer>> res = new ArrayList<>();

 		if(root == null)	return res;

 		int size = 0;
 		Queue<TreeNode> q = new LinkedList<>();
 		q.add(root);

 		while(!q.isEmpty()) {
 			size = q.size();
 			List<Integer> subres = new ArrayList<>();

 			for(int i = 0; i < size; i++) {
 				TreeNode cur = q.poll();
 				subres.add(cur.val);

 				if(cur.left != null)	q.add(cur.left);
 				if(cur.right != null)	q.add(cur.right);
 			}

 			res.add(subres);
 		}
        
        Collections.reverse(res);
 		return res;
    }
}
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
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	Stack<TreeNode>	stack = new Stack<>();

    	if(root == null)	return res; //base case

    	TreeNode p = root;
    	while(p != null) {
    		stack.push(p);
    		p = p.left;
    	}

    	while(!stack.isEmpty()) {
    		TreeNode cur = stack.pop();
    		res.add(cur.val);
    		if (cur.right != null) {
    			p = cur.right;
    			while(p != null) {
    				stack.push(p);
    				p = p.left;
    			}
    		}
    	}

    	return res;
    }
}
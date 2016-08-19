/*
tree inorder non-recursion

1. put all left to the stack
2. pop the stack : => cur
	if cur.right is not empty {
		putalltoLeft(cur.right, stack)
	}

	if cur.right is empty
*/


public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null) {
			return res;
		}

		putAllToLeft(root, stack);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);

			if (cur.right != null) {
				putAllToLeft(cur.right, stack);
			}
		}

		return res;
	}

	public void putAllToLeft(TreeNode root, Stack stack) {
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}

}
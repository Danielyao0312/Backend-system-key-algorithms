/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution{
	static class ReturnType{
		long singlePath;	//with root
		long maxPath; // without root
		ReturnType(long singlePath, long maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	public int maxPathSum(TreeNode root) {
		ReturnType res = findMaxPathWithRootAndWithoutRoot(root);
		return (int)Math.max(res.singlePath, res.maxPath);
	}

	private ReturnType findMaxPathWithRootAndWithoutRoot(TreeNode root) {
		if(root == null)	return new ReturnType(Integer.MIN_VALUE, Integer.MIN_VALUE);
		
		ReturnType left = findMaxPathWithRootAndWithoutRoot(root.left);
		ReturnType right = findMaxPathWithRootAndWithoutRoot(root.right);

		long maxWithRoot = Collections.max(Arrays.asList(
			left.singlePath + root.val,
			right.singlePath + root.val,
			(long)root.val
		));

		long maxWithoutRoot = Collections.max(Arrays.asList(
			left.maxPath,
			right.maxPath,
			left.singlePath,
			right.singlePath,
			left.singlePath + root.val + right.singlePath
		));

		return new ReturnType(maxWithRoot, maxWithoutRoot);
	}
}
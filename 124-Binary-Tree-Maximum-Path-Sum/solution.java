/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * get a path from an arbitrary node to another arbitrary node which
 * the sum of node's value along the path is the maximum in the tree
 */
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
		public final long singlePath;	//with root
		public final long maxPath; // without root
		public ReturnType(long singlePath, long maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

    public int fix(long num) {
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }
    
	public int maxPathSum(TreeNode root) {
		ReturnType maxValue = findMaxPathWithRootAndWithoutRoot(root);
		return Math.max(fix(maxValue.singlePath), fix(maxValue.maxPath));
	}

	public ReturnType findMaxPathWithRootAndWithoutRoot(TreeNode root) {
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

//convert sorted array to binary search tree 解题报告

/*
子问题拆解：BST 的inorder traversal 是一个递增的 sorted list， 因此当情况反过来时，这个数组的中点，就必然是 tree 的根，然后这个中点将array 天然拆成左右两半，左边一般构成了 root 的左子树，右边一半构成了 root 的右子树

子问题各个击破：
root : 找到 array 中点，以它的 val 直接 new 一个新的树节点
左半边 array: 递归的以左半部分 array 建树，返回一个根叫做 left
右半边 array: 递归的以右半部分 array 建树，返回一个根叫做 right

最后拼接起来, root.left = left, root.right = right
整棵树就构建完成, 当然这里还需要考虑递归的 base case 就是 root == null 时 return null

可视化过程: 


*/

public class Solution {
	public TreeNode sortedArrayToBST(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return buildTree(arr, 0, arr.length - 1);
	}

	private TreeNode buildTree(int[] arr, int start, int end) {
		if (start > end)    return null;

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildTree(arr, start, mid - 1);
		root.right = buildTree(arr, mid + 1, end);

		return root;
	}
}
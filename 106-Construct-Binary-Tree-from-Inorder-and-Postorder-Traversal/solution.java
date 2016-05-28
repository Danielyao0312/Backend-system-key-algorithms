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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	int inEnd = inorder.length - 1;
    	int postEnd = postorder.length - 1;
        return helper(inorder, 0, inEnd, postorder, 0, postEnd);
    }
    
    private TreeNode helper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        //corner case:
        if(inStart > inEnd || postStart > postEnd)	return null;

        //find the root pos in the inorder array
        int rootVal = post[postEnd];
        int pos = 0;	// the pos of root in the inorder array
        for(int i = inStart; i <= inEnd; i++) {
        	if (in[i] == rootVal) {
        		pos = i;
        		break;
        	}
        }
        
        int len = pos - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(in, inStart, pos - 1, post, postStart, postStart + len - 1);
        root.right = helper(in, pos + 1, inEnd, post, postStart + len, postEnd - 1);

        return root;
    }
}
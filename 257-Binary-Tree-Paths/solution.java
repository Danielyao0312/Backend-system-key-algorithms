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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        List<StringBuilder> sbres = helper(root);

        for (StringBuilder i : sbres) {
            res.add(i.toString());
        }
        return res;
        
    }
    
    public List<StringBuilder> helper(TreeNode root) {
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        StringBuilder sb = new StringBuilder();

        //base cases:
        if (root == null) {
            return res;
        }

        if(root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb);
            return res;
        }

        //divide and recursively do something to left and right
        List<StringBuilder> resleft = helper(root.left);
        List<StringBuilder> resright = helper(root.right);
        for (StringBuilder i : resleft) {
            String rootval = Integer.toString(root.val);
            i.insert(0, "->");
            i.insert(0, rootval);
        }
        for (StringBuilder i : resright) {
            String rootval = Integer.toString(root.val);
            i.insert(0, "->");
            i.insert(0, rootval);
        }

        //combine left and right
        res.addAll(resleft);
        res.addAll(resright);

        return res;
    }
}
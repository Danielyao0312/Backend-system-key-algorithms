/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushLeftChildren(root); // find the first node (leftmost) to start, and store the trace
    }

    // push all the left subnodes to stack until reaching the first node in inorder (the leftmost node)
    private void pushLeftChildren(TreeNode curr) {
        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        // if (!hasNext()) throw new NoSuchElementException("All nodes have been visited");
        
        TreeNode res = stack.pop();
        pushLeftChildren(res.right);
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
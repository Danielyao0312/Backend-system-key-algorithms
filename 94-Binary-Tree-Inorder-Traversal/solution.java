//my solution:
public class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) return res;
    
        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushAllLeft(cur.right, stack);
        }
        return res;
    }

    public void pushAllLeft(TreeNode node, Stack stack){
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}

// other solution:
// public class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//     	List<Integer> res = new ArrayList<>();
//     	Stack<TreeNode>	stack = new Stack<>();

//         TreeNode cur = root;
        
//         while(cur != null || !stack.isEmpty()) {
//             while(cur != null) {
//                 stack.push(cur);
//                 cur = cur.left;
//             }
//             cur = stack.pop();
//             res.add(cur.val);
//             cur = cur.right;
//         }

//         return res;
//     }
// }

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null) return true;
    //     ArrayList<Integer> result = inorderTraversal(root);
    //     for(int i = 1; i < result.size(); i++){
    //         if(result.get(i - 1) >= result.get(i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
        
    //     if(root == null){
    //         return result;
    //     }
    //     result.addAll(inorderTraversal(root.left));
    //     result.add(root.val);
    //     result.addAll(inorderTraversal(root.right));
        
    //     return result;
    // }
    
// 大神算法 version 2
/*根据题目中的定义来实现，其实就是对于每个结点保存左右界，也就是保证结点满足它的左子树的每个结点比当前结点值小，右子树的每个结点比当前结点值大。对于根节点不用定位界，所以是无穷小到无穷大，接下来当我们往左边走时，上界就变成当前结点的值，下界不变，而往右边走时，下界则变成当前结点 值，上界不变。如果在递归中遇到结点值超越了自己的上下界，则返回false，否则返回左右子树的结果。” 
*/
    public static boolean isValidBST(TreeNode root) {  
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);  
    }
    
    // 用最小值和最大值，来限定子树的范围  
    public static boolean rec(TreeNode root, long min, long max){  
        if(root == null)    return true;
          
        // 不在范围内  
        if(root.val <= min || root.val >= max){  
            return false;  
        }  
          
        // 检查左右子树的合法性并更新上下限  
        return rec(root.left, min, root.val) && rec(root.right, root.val, max);  
    }  


//version 3:
    
    /**
     * Recursive
     * Check current node
     * Check left subtree
     * Compare with current node and set predecessor
     * Check right subtree
     */
     
    // long pred = Long.MIN_VALUE;
    
    // public boolean isValidBST(TreeNode root) { 
    //     if (root == null)   
    //         return true;
        
    //     //left
    //     if (!isValidBST(root.left))     
    //         return false;
        
    //     //visit
    //     if (root.val <= pred)   
    //         return false;
    //     pred = root.val;
        
    //     //right
    //     if (!isValidBST(root.right)) 
    //         return false;
    //     return true; //otherwise
    // }
	

}
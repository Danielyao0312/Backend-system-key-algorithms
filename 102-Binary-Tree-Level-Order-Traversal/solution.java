/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // this is a BFS question, use queue to store data and traverse, record the level
        /*
        本题实质是广度优先搜索BFS，而用队列可以轻松的以迭代形式实现它。不过不同于BFS的是，层序遍历需要在队列中记住每一层的分割点，而BFS不关心层数只要遍历到指定元素就行了。为了记住这个分割点，我们在进入下一层之前先记下这一层的元素个数N（其实就是当前queue的大小），然后只遍历N个节点（展开下一层节点的同时queue中会新加入很多下下一层的节点）。遍历完N个节点后记录新的层数，再进入下一层。对于II，返回的层是逆序的，我们只要在结果中，每次把下面新一层加到当前这层的前面就行了
        
        */
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null) return result;
        int numOfNode = 0;

        queue.offer(root);
        while(!queue.isEmpty()){
        	List<Integer> subarray = new ArrayList<>();
        	numOfNode = queue.size();
        	
            //控制当前层的遍历次数
        	while(numOfNode != 0) {
        		TreeNode temp = queue.poll();
        		subarray.add(temp.val);

        		if(temp.left != null)
        			queue.offer(temp.left);
        		if(temp.right != null)
        			queue.offer(temp.right);
        		numOfNode--;
        	}
        	result.add(subarray);

        }

        return result;
    }
}
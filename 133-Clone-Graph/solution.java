/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
     
    /*
    1. find nodes:
        用 BFS 找到所有的 node （queue + hashset）
    2. clone nodes:
        用一个 hashmap， 对于每一个node, 创建一个新 node，并建立 hash 对应关系
    3. clone edges:
        把 旧 node 中 的 neighbor 中的每一个 node 对应的新 node, 加入到 新 node 的 neighbor 中去
    */ 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        
        ArrayList<UndirectedGraphNode> nodes = findNodes(node);
        
        //step 2:
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode i : nodes) {
            map.put(i, new UndirectedGraphNode(i.label));
        }
        
        //step 3:
        for (UndirectedGraphNode i : nodes) {
            UndirectedGraphNode newNode = map.get(i);
            for (UndirectedGraphNode j : i.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(j);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
        
    }
    
    // step 1:
    private ArrayList<UndirectedGraphNode> findNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        q.add(node);
        set.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode i : cur.neighbors) {
                if (!set.contains(i)) {
                    set.add(i);
                    q.add(i);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
    
    
}
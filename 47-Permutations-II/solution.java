/*
Backtracking: Time ~ O(N!), Extra Space ~ O(N) 
Must sort first (因为仅判断相邻是否 duplicates)!

用一个 HashSet 记录访问过的元素 index，因为有duplicates，不能用 list.contains(num[i]) 判断是否该元素已经被加入排列。

Backtracking is needed here (since DFS exceeds time limit!) 

剪枝的条件: 发现相同元素，且前一个相同元素没有用过（如果用过则是一个新排列）。
!vistied.contains(i - 1) && num[i - 1] == num[i]
No need to check duplicate lists here, since the pruning already takes out the duplicates.

*/

public class Solution {
    
    private List<List<Integer>> res;
    private List<Integer> list;
    private Set<Integer> visited;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        visited = new HashSet<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }
    
    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i) || i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i]) { // key point!!!
                continue;
            }
            
            visited.add(i); // i被访问
            
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size() - 1);
            
            visited.remove(i); // i 退回未被访问的状态
        }
        
    }
}
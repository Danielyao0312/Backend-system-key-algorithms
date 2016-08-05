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
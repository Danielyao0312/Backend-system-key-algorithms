public class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if(nums == null || nums.length == 0 || target < 0)  return res;
        
        Arrays.sort(nums);
        dfs(res, list, nums, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int pos) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }else if(target < 0) { // key point!!!
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;  // avoid duplicates
            }
            
            list.add(nums[i]);
            dfs(res, list, nums, target - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
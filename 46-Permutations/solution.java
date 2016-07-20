public class Solution {
    
    /*
    1. 把以1，2，3分别开头的结果加入 res中
    2. 出口，当结果数组长度为总长时
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        helper(res, list, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        // 出口:
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
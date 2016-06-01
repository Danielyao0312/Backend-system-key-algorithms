public class Solution {
    //1.intput: an array, output: List<List<Integer>>
    //2.crack the question: search for ALL POSSIBLE results -> dfs solution -> backtracking
    //  dfs question -> using a helper function, recursive solve the problem
    //3.corner cases: nums == null
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        
        if(nums.length == 0 || nums == null)    return res;
        
        helper(res, subres, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> subres, int[] nums) {
        if(subres.size() == nums.length){
            res.add(new ArrayList<Integer>(subres));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(subres.contains(nums[i]))    continue;
            
            subres.add(nums[i]);
            helper(res, subres, nums);
            subres.remove(subres.size() - 1);
        }
        
    }
}
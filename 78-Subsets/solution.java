
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subres = new ArrayList<>();

		if(nums.length == 0 || nums == null)	return res;

		Arrays.sort(nums);
		helper(res, subres, nums, 0);
		return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> subres, int[] nums, int pos){
    	res.add(new ArrayList<Integer>(subres));

    	for(int i = pos; i < nums.length; i++) {
    		subres.add(nums[i]);
    		helper(res, subres, nums, i + 1);
    		subres.remove(subres.size() - 1);
    	}
    }
}
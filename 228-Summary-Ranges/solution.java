/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

*/


public class Solution {
	// use two pointer, lo and hi, if

    public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();

		if (nums == null && nums.length == 0)	
		    return res;

		if (nums.length == 1) {
		    res.add(nums[0] + "");
		    return res;
		}

		for (int i = 0; i < nums.length; i++) {
			int low = nums[i];

			while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
				i++;
			}
			if (low == nums[i]) {
				res.add(low + "");
			} else {
				res.add(low + "->" + nums[i]);
			}
		
		}

		return res;   
    }
}
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

/*
1. sort the nums

2. for every element i in nums, use two pointer to find if there is a 2Sum = 0 - i => i + 2sum = 0?  
become 2sum problem
duplicate: make sure to skip duplicate

add to res

两个要去重的地方：
1. fixed element (即nums[i]) 有重复要跳过
2. 当 求和等于结果时, 需要把双指针左右两边重复的值跳过！
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (nums == null || nums.length == 0) {
    		return res;
    	}

    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++) {
    		int cur = nums[i];
    		if (i > 0 && nums[i] == nums[i - 1]){
    			continue;
    		}
    		int lo = i + 1;
    		int hi = nums.length - 1;
    		while (lo < hi) {
    			int sum = cur + nums[lo] + nums[hi];
    			if (sum == 0) {
    				List<Integer> temp = new ArrayList<>();
    				temp.add(cur);
    				temp.add(nums[lo]);
    				temp.add(nums[hi]);
    				res.add(temp);
    				lo ++;
    				hi --;
    				while (lo < hi && nums[lo] == nums[lo - 1]) {
    					lo ++;
    				}
    				while (lo < hi && nums[hi] == nums[hi + 1]) {
    					hi --;
    				}
    			} else if (sum < 0) {
    				lo ++;
    			} else {
    				hi --;
    			}
    		}

    	}
    	return res;

    }
}
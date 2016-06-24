// similarly to best time to buy and sell stock
// calculate prefixSum[], the biggest difference between prefixSum, is the result.
// when calculate sum, always find the minSum before current element, 

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }   
}